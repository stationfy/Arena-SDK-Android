package im.arena.sample.analytics

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import im.arena.analytics.Analytics
import im.arena.analytics.Environment
import im.arena.commons.LogLevel
import im.arena.sample.R
import kotlinx.android.synthetic.main.activity_analytics.*

class ActivityAnalytics : AppCompatActivity() {
    companion object {
        private const val WRITE_KEY = "NWU3MjNhMTgwMDE3YmMwMDA3YzgyYTI0Om1vYmlsZTpkZWZhdWx0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analytics)
        Analytics
            .logLevel(LogLevel.DEBUG)
            .environment(Environment.PRODUCTION)
            .configure(application, WRITE_KEY)

        activity_analytics_button_send_screen.setOnClickListener {
            Analytics.instance().page(
                "Home Activity",
                hashMapOf(Pair("firstTime", "true"))
            )
        }

        activity_analytics_button_send_track.setOnClickListener {
            Analytics.instance().track(
                "Post Reacted",
                hashMapOf(
                    Pair("postId", "WOR06DvfpcRaylQJoZeu"),
                    Pair("reaction", "thumbs_up")
                )
            )
        }

        activity_analytics_button_send_identify.setOnClickListener {
            Analytics.instance().identify(
                "jf8sjgnvsia0381",
                hashMapOf(
                    Pair("name", "John Doe"),
                    Pair("email", "john@nocompany.com"),
                    Pair("plan", "business")
                )
            )
        }
    }

}