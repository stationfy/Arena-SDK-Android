package im.arena.sample.liveblog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import im.arena.commons.LogLevel
import im.arena.liveblog.LiveBlog
import im.arena.liveblog.LiveBlogCallback
import im.arena.realtimedata.Environment
import im.arena.sample.R
import im.arena.sample.SampleApplication
import im.arena.sample.common.alertDialog
import kotlinx.android.synthetic.main.activity_live_blog.*


class ActivityLiveBlog : AppCompatActivity(), LiveBlogCallback {

    private var alertDialogInput: AlertDialog? = null
    private lateinit var alertDialogLayout: View
    private lateinit var appCompatEditTextPublisherSlug: AppCompatEditText
    private lateinit var appCompatEditTextEventSlug: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_blog)
        LiveBlog.configure(SampleApplication.instance, LogLevel.DEBUG, Environment.PRODUCTION)

        alertDialogLayout =
            LayoutInflater.from(baseContext).inflate(R.layout.alert_dialog_live_blog, null, false)
        appCompatEditTextPublisherSlug =
            alertDialogLayout.findViewById(R.id.alert_dialog_live_blog_edit_text_publish_slug)
        appCompatEditTextEventSlug =
            alertDialogLayout.findViewById(R.id.alert_dialog_live_blog_edit_text_event_slug)

        showAlertDialogLiveBlog(live_blog)
    }

    private fun showAlertDialogLiveBlog(liveBlog: LiveBlog) {
        alertDialogInput =
            alertDialog(alertDialogLayout, DialogInterface.OnClickListener { dialogInterface, _ ->
                liveBlog.start(
                    appCompatEditTextPublisherSlug.text.toString(),
                    appCompatEditTextEventSlug.text.toString(),
                    this,
                    this
                )
                dialogInterface.dismiss()
            })
    }

    override fun onDestroy() {
        alertDialogInput = null
        super.onDestroy()
    }

    override fun onItemClick(view: View?, position: Int) {
    }
}