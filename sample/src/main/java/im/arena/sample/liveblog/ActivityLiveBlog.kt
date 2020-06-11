package im.arena.sample.liveblog

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import im.arena.liveblog.LiveBlogCallback
import im.arena.sample.R
import kotlinx.android.synthetic.main.activity_live_blog.*

class ActivityLiveBlog : AppCompatActivity(), LiveBlogCallback {
    companion object {
        const val EXTRA_PUBLISHER_SLUG = "EXTRA_PUBLISHER_SLUG"
        const val EXTRA_EVENT_SLUG = "EXTRA_EVENT_SLUG"

        const val PUBLISHER_SLUG = "qa-sdk"

        const val EVENT_SLUG_GENERAL = "buly"
        const val EVENT_SLUG_GOLF = "fw8i"
        const val EVENT_SLUG_SOCCER = "yjsv"
        const val EVENT_SLUG_BASEBALL = "zrcz"
        const val EVENT_SLUG_BASKETBALL = "wza0"
        const val EVENT_SLUG_MOTOSPORT = "m4iy"
        const val EVENT_SLUG_MIDIA = "cvz7"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_blog)

        live_blog.start(
            intent?.getStringExtra(EXTRA_PUBLISHER_SLUG) ?: "",
            intent?.getStringExtra(EXTRA_EVENT_SLUG) ?: "",
            this, this
        )
    }

    override fun onItemClick(view: View?, position: Int) {
        makeText(baseContext, "Click card!", Toast.LENGTH_LONG).show()
    }
}