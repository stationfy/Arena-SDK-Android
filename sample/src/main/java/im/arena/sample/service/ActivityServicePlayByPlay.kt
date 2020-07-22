package im.arena.sample.service

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import im.arena.realtimedata.RealTimeData
import im.arena.realtimedata.model.OrderBy
import im.arena.sample.R
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

        activity_service_play_by_play_recycler_view.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = adapterServicePlayByPlay
        }

        loadCache()
    }

    private fun loadCache() {
        RealTimeData
            .instance()
            .cachedRepository
            .load(PUBLISHER_SLUG, EVENT_SLUG_GENERAL,
                {
                    loadStreaming(it.eventInfo?.key)
                },
                {
                    makeText(baseContext, it.message, Toast.LENGTH_SHORT)
                        .show()
                })
    }

    private fun loadStreaming(eventId: String?) {
        RealTimeData
            .instance()
            .playByPlay
            .apply {
                realtime(eventId,
                    orderBy = OrderBy.NEWEST,
                    success = {
                        adapterServicePlayByPlay.submitList(it)
                        activity_service_play_by_play_progress.visibility = View.GONE
                        activity_service_play_by_play_recycler_view.visibility = View.VISIBLE
                    },
                    failure = {
                        makeText(baseContext, it.message, Toast.LENGTH_SHORT)
                            .show()
                    })
            }
    }
}