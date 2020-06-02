package im.arena.sample

import android.app.Application
import im.arena.analytics.Analytics
import im.arena.liveblog.LiveBlog
import im.arena.realtimedata.Environment
import im.arena.realtimedata.RealTimeData

class SampleApplication : Application() {
    companion object {
        private const val WRITE_KEY = "NWU3MjNhMTgwMDE3YmMwMDA3YzgyYTI0Om1vYmlsZTpkZWZhdWx0"
    }

    override fun onCreate() {
        super.onCreate()

        RealTimeData.configure(this, Environment.DEVELOPMENT)
        Analytics.configure(this, WRITE_KEY)
        LiveBlog.configure(this)
    }
}