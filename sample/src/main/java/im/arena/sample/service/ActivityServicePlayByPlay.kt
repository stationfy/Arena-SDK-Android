package im.arena.sample.service

import android.annotation.SuppressLint
import android.app.Application
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
import im.arena.sample.databinding.ActivityHomeBinding
import im.arena.sample.databinding.ActivityLiveBlogBinding
import im.arena.sample.databinding.ActivityServicePlayByPlayBinding

class ActivityServicePlayByPlay : AppCompatActivity() {
    companion object {
        private const val PUBLISHER_SLUG = "qa-sdk"
        private const val EVENT_SLUG_GENERAL = "buly"
    }

    private var activityServicePlayByPlayBinding: ActivityServicePlayByPlayBinding? = null

    private val adapterServicePlayByPlay = AdapterServicePlayByPlay()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ActivityServicePlayByPlayBinding
                .inflate(layoutInflater)
                .also { activityServicePlayByPlayBinding = it }
                .root)

        RealTimeData
            .logLevel(LogLevel.DEBUG)
            .configure(applicationContext as Application, Environment.PRODUCTION)

        activityServicePlayByPlayBinding?.activityServicePlayByPlayRecyclerView?.apply {
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

    override fun onDestroy() {
        activityServicePlayByPlayBinding = null
        super.onDestroy()
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
                    activityServicePlayByPlayBinding?.activityServicePlayByPlayProgress?.visibility = View.GONE
                    activityServicePlayByPlayBinding?.activityServicePlayByPlayRecyclerView?.visibility = View.VISIBLE
                },
                {
                    makeText(baseContext, it.message, Toast.LENGTH_SHORT)
                        .show()
                }
            )
    }
}