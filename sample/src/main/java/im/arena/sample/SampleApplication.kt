package im.arena.sample

import android.app.Application
import im.arena.analytics.Analytics
import im.arena.liveblog.LiveBlog

class SampleApplication : Application() {
    companion object {
        private const val WRITE_KEY = "NWU3MjNhMTgwMDE3YmMwMDA3YzgyYTI0Om1vYmlsZTpkZWZhdWx0"
    }

    override fun onCreate() {
        super.onCreate()

        LiveBlog.configure(
            this,
            BuildConfig.APPLICATION_ID,
            BuildConfig.VERSION_NAME,
            im.arena.streaming.Environment.DEVELOPMENT
        )

        Analytics
            .widgetId("-L5sDkM-c1vZjTt4UOT4")
            .widgetType("Liveblog")
            .configure(this, WRITE_KEY, im.arena.analytics.AnalyticsEnvironment.PRODUCTION)
    }
}