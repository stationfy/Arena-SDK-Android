package im.arena.sample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import im.arena.sample.analytics.ActivityAnalytics
import im.arena.sample.chat.ActivityChat
import im.arena.sample.databinding.ActivityHomeBinding
import im.arena.sample.liveblog.ActivityLiveBlog
import im.arena.sample.service.ActivityServicePlayByPlay

class ActivityHome : AppCompatActivity(), AdapterHome.OnClickListener {
    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    private var activityHomeBinding: ActivityHomeBinding? = null

    private val componentsList: List<String> = listOf(
        "Live Blog",
        "Chat",
        "Analytics",
        "Realtime"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityHomeBinding
            .inflate(layoutInflater)
            .also { activityHomeBinding = it }
            .root)

        activityHomeBinding?.recyclerViewHome?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = AdapterHome(componentsList, this@ActivityHome)
        }
    }

    override fun onDestroy() {
        activityHomeBinding = null
        super.onDestroy()
    }

    override fun click(view: View?, position: Int) {
        when (position) {
            0 -> startActivity(Intent(this, ActivityLiveBlog::class.java))

            1 -> startActivity(Intent(this, ActivityChat::class.java))

            2 -> startActivity(Intent(this, ActivityAnalytics::class.java))

            3 -> startActivity(Intent(this, ActivityServicePlayByPlay::class.java))
        }
    }

}