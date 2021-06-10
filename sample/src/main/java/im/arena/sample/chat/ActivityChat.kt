package im.arena.sample.chat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.FragmentActivity
import im.arena.chat.ChatViewModel
import im.arena.chat.activity.ChatActivity
import im.arena.commons.LogLevel
import im.arena.realtimedata.Environment
import im.arena.realtimedata.model.ExternalUser
import im.arena.sample.R
import im.arena.sample.common.alertDialog
import kotlin.random.Random


class ActivityChat : FragmentActivity() {
    private lateinit var activityLauncher: ActivityResultLauncher<Intent>
    private var alertDialogInput: AlertDialog? = null
    private val activityResultCallback = ActivityResultCallback<ActivityResult> {
        if (it.resultCode == RESULT_FIRST_USER) {
            Toast
                .makeText(this, "Login with your system", Toast.LENGTH_SHORT)
                .show()

            ChatViewModel
                .externalUser(
                    ExternalUser(
                        "123123",
                        "Roberto",
                        "roberto@gmail.com",
                        "https://randomuser.me/api/portraits/women/${
                            Random.nextInt(
                                0,
                                50
                            )
                        }.jpg",
                        "Silva",
                        "Lima"
                    )
                )

            ChatActivity
                .start(this, activityLauncher)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        activityLauncher = registerForActivityResult()

        if (savedInstanceState == null) {
            showAlertDialogChat()
        }
    }

    private fun registerForActivityResult() = (this as ComponentActivity).registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(), activityResultCallback
    )

    private fun showAlertDialogChat() {
        lateinit var appCompatEditTextWriteKey: AppCompatEditText
        lateinit var appCompatEditTextSlug: AppCompatEditText
        lateinit var appCompatSpinnerEnvironment: AppCompatSpinner

        val view =
            LayoutInflater.from(baseContext).inflate(R.layout.alert_dialog_chat, null, false)
                .apply {
                    appCompatEditTextWriteKey =
                        findViewById(R.id.alert_dialog_chat_edit_text_write_key)

                    appCompatEditTextSlug =
                        findViewById(R.id.alert_dialog_chat_edit_text_event_slug)

                    appCompatSpinnerEnvironment =
                        findViewById(R.id.alert_dialog_chat_spinner_environment)
                }

        alertDialogInput = alertDialog(view) { dialogInterface, _ ->
            val environment =
                if (appCompatSpinnerEnvironment.selectedItemPosition == 0)
                    Environment.DEVELOPMENT else Environment.PRODUCTION

            ChatActivity
                .logLevel(LogLevel.DEBUG)
                .environment(environment)
                .configure(
                    application,
                    appCompatEditTextWriteKey.text.toString(),
                    appCompatEditTextSlug.text.toString()
                )

            dialogInterface.dismiss()

            ChatActivity
                .start(this, activityLauncher)

            finish()
        }
    }
}