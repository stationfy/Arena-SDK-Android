package im.arena.sample

import android.app.Application
import im.arena.sample.BuildConfig.DEBUG

class SampleApplication : Application() {
    companion object {
        lateinit var instance: SampleApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}