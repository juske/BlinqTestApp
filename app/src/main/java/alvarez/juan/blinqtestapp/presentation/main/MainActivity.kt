package alvarez.juan.blinqtestapp.presentation.main

import alvarez.juan.blinqtestapp.R
import alvarez.juan.blinqtestapp.databinding.ActivityMainBinding
import alvarez.juan.blinqtestapp.presentation.cancel.CancelFragment
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean(getString(R.string.shared_preferences), false)) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, MainFragment::class.java, null)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, CancelFragment::class.java, null)
                .commit()
        }
    }
}