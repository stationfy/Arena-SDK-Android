package im.arena.sample.service

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import im.arena.realtimedata.RealTimeData
import im.arena.sample.R
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.EVENT_SLUG_GENERAL
import im.arena.sample.liveblog.ActivityLiveBlog.Companion.PUBLISHER_SLUG
import kotlinx.android.synthetic.main.activity_service_play_by_play.*

class ActivityServicePlayByPlay : AppCompatActivity() {
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
            .cached
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
                realtime(
                    query(eventId),
                    {
                        adapterServicePlayByPlay.submitList(it)
                        activity_service_play_by_play_progress.visibility = View.GONE
                        activity_service_play_by_play_recycler_view.visibility = View.VISIBLE
                    },
                    {
                        makeText(baseContext, it.message, Toast.LENGTH_SHORT)
                            .show()
                    })
            }
    }
}