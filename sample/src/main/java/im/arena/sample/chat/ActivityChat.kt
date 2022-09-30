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
    private lateinit var appCompatEditTextWriteKey: AppCompatEditText
    private lateinit var appCompatEditTextSlug: AppCompatEditText
    private lateinit var appCompatSpinnerEnvironment: AppCompatSpinner
    private var alertDialogInput: AlertDialog? = null
    private val chat by lazy {
        Chat
            .logLevel(LogLevel.DEBUG)
            .environment(
                if (appCompatSpinnerEnvironment.selectedItemPosition == 0)
                Environment.DEVELOPMENT
                else Environment.PRODUCTION
            )
            .apply {
                configure(
                    application,
                    appCompatEditTextWriteKey.text.toString(),
                    appCompatEditTextSlug.text.toString()
                )
            }
            .newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ActivityChatBinding
                .inflate(layoutInflater)
                .also { activityChatBinding = it }
                .root)

        observeEvents()

        if (savedInstanceState == null) {
            showAlertDialogChat()
        }
    }

    private fun showAlertDialogChat() {

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
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activity_chat_container,
                chat
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
                else -> {}
            }
        }
    }
}