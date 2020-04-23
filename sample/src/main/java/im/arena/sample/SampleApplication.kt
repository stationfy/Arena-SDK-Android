package im.arena.sample

import android.app.Application
import im.arena.liveblog.LiveBlog
import im.arena.streaming.Environment

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        LiveBlog.setup(
            this,
            BuildConfig.APPLICATION_ID,
            BuildConfig.VERSION_NAME,
            Environment.DEVELOPMENT
        )
    }
}