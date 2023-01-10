package alvarez.juan.blinqtestapp.presentation.cancel

import alvarez.juan.blinqtestapp.R
import alvarez.juan.blinqtestapp.presentation.main.MainActivity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment

class CancelFragment: Fragment(R.layout.fragment_cancel) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            val sharedPreferences: SharedPreferences = it.getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.apply {
                putBoolean(getString(R.string.shared_preferences_user_registered), false)
            }.apply()
        }

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(activity?.applicationContext, MainActivity::class.java)
                startActivity(intent)
            },3000
        )
    }

}