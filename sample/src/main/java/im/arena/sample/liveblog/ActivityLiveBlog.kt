package im.arena.sample.liveblog

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import im.arena.commons.LogLevel
import im.arena.liveblog.LiveBlog
import im.arena.liveblog.commons.LiveBlogCallback
import im.arena.realtimedata.Environment
import im.arena.realtimedata.RealTimeData
import im.arena.sample.R
import im.arena.sample.common.alertDialog
import im.arena.sample.databinding.ActivityLiveBlogBinding


class ActivityLiveBlog : AppCompatActivity(), LiveBlogCallback {
    companion object {
        private const val PUBLISHER_SLUG = "qa-sdk"
        private const val EVENT_SLUG_GENERAL = "buly"
        private const val EVENT_SLUG_GOLF = "fw8i"
        private const val EVENT_SLUG_SOCCER = "yjsv"
        private const val EVENT_SLUG_BASEBALL = "zrcz"
        private const val EVENT_SLUG_BASKETBALL = "wza0"
        private const val EVENT_SLUG_MOTOSPORT = "m4iy"
        private const val EVENT_SLUG_MIDIA = "cvz7"
    }

    private var activityLiveBlogBinding: ActivityLiveBlogBinding? = null
    private var alertDialogInput: AlertDialog? = null
    private lateinit var appCompatEditTextPublisherSlug: AppCompatEditText
    private lateinit var appCompatEditTextEventSlug: AppCompatEditText
    private lateinit var appCompatSpinnerEventEntries: AppCompatSpinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ActivityLiveBlogBinding
                .inflate(layoutInflater)
                .also { activityLiveBlogBinding = it }
                .root)

        if (savedInstanceState == null) {
            showAlertDialogLiveBlog(activityLiveBlogBinding?.liveBlog)
        }
    }

    override fun onItemClick(view: View?, position: Int) {
    }

    override fun onPredictionItemClick(view: View?, position: Int) {
    }

    override fun onLiveScoreItemClick(view: View?, position: Int) {
    }

    override fun onItemClick(view: View?, positionParent: Int, positionChild: Int) {
    }

    override fun onDestroy() {
        alertDialogInput = null
        activityLiveBlogBinding = null
        super.onDestroy()
    }

    private fun showAlertDialogLiveBlog(liveBlog: LiveBlog?) {
        val view =
            LayoutInflater.from(baseContext).inflate(R.layout.alert_dialog_live_blog, null, false)
                .apply {
                    appCompatEditTextPublisherSlug =
                        findViewById(R.id.alert_dialog_live_blog_edit_text_publish_slug)

                    appCompatEditTextEventSlug =
                        findViewById(R.id.alert_dialog_live_blog_edit_text_event_slug)

                    appCompatSpinnerEventEntries =
                        findViewById(R.id.alert_dialog_live_blog_spinner_environment)
                }

        alertDialogInput = alertDialog(view) { dialogInterface, _ ->
            val environment =
                if (appCompatSpinnerEventEntries.selectedItemPosition == 0)
                    Environment.PRODUCTION else Environment.DEVELOPMENT

            RealTimeData
                .logLevel(LogLevel.DEBUG)
                .configure(applicationContext as Application, environment)

            LiveBlog
                .logLevel(LogLevel.DEBUG)
                .environment(environment)
                .configure(
                    baseContext.applicationContext as Application,
                    appCompatEditTextPublisherSlug.text.toString(),
                    appCompatEditTextEventSlug.text.toString()
                )

            liveBlog?.start()
            dialogInterface.dismiss()
        }
    }
}