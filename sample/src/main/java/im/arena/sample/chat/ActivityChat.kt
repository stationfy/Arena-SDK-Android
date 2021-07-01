package im.arena.sample.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.FragmentActivity
import im.arena.chat.fragment.Chat
import im.arena.chat.model.Events
import im.arena.commons.LogLevel
import im.arena.realtimedata.Environment
import im.arena.realtimedata.model.ExternalUser
import im.arena.sample.R
import im.arena.sample.common.alertDialog
import im.arena.sample.databinding.ActivityChatBinding
import kotlin.random.Random


class ActivityChat : FragmentActivity() {
    private lateinit var activityChatBinding: ActivityChatBinding
    private var alertDialogInput: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityChatBinding
            .inflate(layoutInflater)
            .run {
                activityChatBinding = this
                activityChatBinding.root
            })

        observeEvents()

        if (savedInstanceState == null) {
            showAlertDialogChat()
        }
    }

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

            val fragment = Chat
                .logLevel(LogLevel.DEBUG)
                .environment(environment)
                .apply {
                    configure(
                        application,
                        appCompatEditTextWriteKey.text.toString(),
                        appCompatEditTextSlug.text.toString()
                    )
                }
                .newInstance()

            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.activity_chat_container,
                    fragment
                )
                .commitAllowingStateLoss()

            dialogInterface.dismiss()
        }
    }

    private fun observeEvents() {
        Chat.liveDataEvents().observe(this) { events: Events ->
            when (events) {
                Events.SSO_REQUIRED -> {
                    Toast
                        .makeText(this, "Login with your system", Toast.LENGTH_SHORT)
                        .show()

                    Chat
                        .loggedUser(
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

                }
            }
        }
    }
}