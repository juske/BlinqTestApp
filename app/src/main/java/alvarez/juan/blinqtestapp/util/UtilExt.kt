package alvarez.juan.blinqtestapp.util

import android.content.Context
import android.widget.Toast

fun Toast.showToast(text: String, context: Context) {
    Toast.makeText(
        context,
        "text",
        Toast.LENGTH_SHORT
    ).show()
}