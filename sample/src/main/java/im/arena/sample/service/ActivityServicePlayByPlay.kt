package im.arena.sample.service

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import im.arena.commons.LogLevel
import im.arena.realtimedata.Environment
import im.arena.realtimedata.RealTimeData
import im.arena.realtimedata.model.OrderBy
import im.arena.sample.R
import im.arena.sample.SampleApplication
import kotlinx.android.synthetic.main.activity_service_play_by_play.*

class ActivityServicePlayByPlay : AppCompatActivity() {
    companion object {
        private const val PUBLISHER_SLUG = "qa-sdk"
        private const val EVENT_SLUG_GENERAL = "buly"
    }

    private val adapterServicePlayByPlay = AdapterServicePlayByPlay()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_play_by_play)
        RealTimeData
            .logLevel(LogLevel.DEBUG)
            .configure(SampleApplication.instance, Environment.PRODUCTION)

        activity_service_play_by_play_recycler_view.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = adapterServicePlayByPlay
        }

        loadCache()
    }

    @SuppressLint("CheckResult")
    private fun loadCache() {
        RealTimeData
            .instance()
            .cachedRepository
            .live(PUBLISHER_SLUG, EVENT_SLUG_GENERAL)
            .subscribe(
                {
                    loadStreaming(it.eventInfo?.key)
                },
                {
                    makeText(baseContext, it.message, Toast.LENGTH_SHORT)
                        .show()
                })
    }

    @SuppressLint("CheckResult")
    private fun loadStreaming(eventId: String?) {
        RealTimeData
            .instance()
            .playByPlay
            .realtime(
                eventId,
                OrderBy.NEWEST
            )
            .subscribe(
                {
                    adapterServicePlayByPlay.submitList(it)
                    activity_service_play_by_play_progress.visibility = View.GONE
                    activity_service_play_by_play_recycler_view.visibility = View.VISIBLE
                },
                {
                    makeText(baseContext, it.message, Toast.LENGTH_SHORT)
                        .show()
                }
            )
    }
}