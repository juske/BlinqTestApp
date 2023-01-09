package alvarez.juan.blinqtestapp.presentation.congratulations

import alvarez.juan.blinqtestapp.R
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class CongratulationsFragment: Fragment(R.layout.fragment_congrats) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            val sharedPreferences: SharedPreferences =
                it.getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply {
                putBoolean(getString(R.string.shared_preferences_user_registered), true)
            }.apply()
        }
    }
}