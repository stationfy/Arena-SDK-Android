package im.arena.sample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import im.arena.sample.analytics.ActivityAnalytics
import im.arena.sample.liveblog.ActivityLiveBlog
import im.arena.sample.service.ActivityServicePlayByPlay
import kotlinx.android.synthetic.main.activity_home.*

class ActivityHome : AppCompatActivity(), AdapterHome.OnClickListener {
    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    private val componentsList: List<String> =
            listOf(
                    "Live Blog Manual",
                    "Analytics",
                    "Service Play By Play"
            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recycler_view_home.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = AdapterHome(componentsList, this@ActivityHome)
        }
    }

    override fun click(view: View?, position: Int) {
        when (position) {
            0 -> startActivity(Intent(this, ActivityLiveBlog::class.java))

            1 -> startActivity(Intent(this, ActivityAnalytics::class.java))

            2 -> startActivity(Intent(this, ActivityServicePlayByPlay::class.java))
        }
    }

}