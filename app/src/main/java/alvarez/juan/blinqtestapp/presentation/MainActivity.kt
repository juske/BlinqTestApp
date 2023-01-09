package alvarez.juan.blinqtestapp.presentation

import alvarez.juan.blinqtestapp.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState)

        val context = applicationContext

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val onButtonClickRequestDialog: OnButtonClickRequestDialog = object : OnButtonClickRequestDialog {
            override fun onClick() {
                //Call Method from here
                
            }
        }

        binding.button.setOnClickListener {

            val alert = EnterRequestDialog()
            alert.showEnterRequestDialog(this, context, onButtonClickRequestDialog)

        }
    }
}