package im.arena.sample.analytics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import im.arena.analytics.Analytics
import im.arena.analytics.Environment
import im.arena.commons.LogLevel
import im.arena.sample.databinding.ActivityAnalyticsBinding

class ActivityAnalytics : AppCompatActivity() {
    companion object {
        private const val WRITE_KEY = "NWU3MjNhMTgwMDE3YmMwMDA3YzgyYTI0Om1vYmlsZTpkZWZhdWx0"
    }

    private var activityAnalyticsBinding: ActivityAnalyticsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityAnalyticsBinding
            .inflate(layoutInflater)
            .also { activityAnalyticsBinding = it }
            .root)

        Analytics
            .logLevel(LogLevel.DEBUG)
            .environment(Environment.PRODUCTION)
            .configure(application, WRITE_KEY)

        activityAnalyticsBinding?.activityAnalyticsButtonSendScreen?.setOnClickListener {
            Analytics.instance().page(
                "Home Activity",
                hashMapOf(Pair("firstTime", "true"))
            )
        }

        activityAnalyticsBinding?.activityAnalyticsButtonSendTrack?.setOnClickListener {
            Analytics.instance().track(
                "Post Reacted",
                hashMapOf(
                    Pair("postId", "WOR06DvfpcRaylQJoZeu"),
                    Pair("reaction", "thumbs_up")
                )
            )
        }

        activityAnalyticsBinding?.activityAnalyticsButtonSendIdentify?.setOnClickListener {
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

    override fun onDestroy() {
        activityAnalyticsBinding = null
        super.onDestroy()
    }

}