package alvarez.juan.blinqtestapp.presentation

import alvarez.juan.blinqtestapp.R
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class EnterRequestDialog {
    fun showEnterRequestDialog(activity: Activity?, context: Context, onButtonClickRequestDialog: OnButtonClickRequestDialog) {
        val dialog = Dialog(activity!!)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.enter_request_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val dialogBtnRequest = dialog.findViewById<TextView>(R.id.btnRequest)
        val dialogNameInput = dialog.findViewById<TextInputLayout>(R.id.etName)
        val dialogEmailInput = dialog.findViewById<TextInputLayout>(R.id.etMail)

        dialogBtnRequest.setOnClickListener {
            if (validateName(context, dialogNameInput) && validateEmail(context, dialogEmailInput)) {
                dialog.dismiss()
                onButtonClickRequestDialog.onClick()
            }
        }

        dialog.show()
    }

    private fun validateName(context: Context, dialogNameInput: TextInputLayout?): Boolean {
        val nameInput = dialogNameInput?.editText?.text.toString().trim()

        if (nameInput.isEmpty()) {
            dialogNameInput?.error = context.getString(R.string.request_name_error)
            return false
        } else {
            dialogNameInput?.error = null
        }

        return if (nameInput.length < MIN_NAME_LENGTH) {
            dialogNameInput?.error = context.getString(R.string.request_short_name_error)
            false
        } else {
            true
        }
    }

    private fun validateEmail(context: Context, dialogEmailInput: TextInputLayout?): Boolean {
        val emailInput = dialogEmailInput?.editText?.text.toString().trim()

        if (emailInput.isEmpty()) {
            dialogEmailInput?.error = context.getString(R.string.request_email_error)
            return false
        } else {
            dialogEmailInput?.error = null
        }

        return if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            true
        } else {
            dialogEmailInput?.error = context.getString(R.string.request_invalid_email_error)
            false
        }

    }

    companion object {
        const val MIN_NAME_LENGTH = 3
    }
}
