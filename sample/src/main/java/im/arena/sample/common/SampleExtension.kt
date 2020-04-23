package im.arena.sample.common

import android.app.Activity
import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import im.arena.sample.R


fun Activity.alertDialog(view: View, onClickListener: DialogInterface.OnClickListener) =
    if (!isFinishing) AlertDialog.Builder(this).apply {
        setView(view)
        setPositiveButton(R.string.alert_dialog_ok, onClickListener)
        setOnCancelListener { it.dismiss() }
        setCancelable(true)
    }.show()
    else null


fun Activity.dialogDismiss(dialog: AlertDialog?) {
    if (!isFinishing && dialog?.isShowing == true) {
        dialog.dismiss()
    }
}