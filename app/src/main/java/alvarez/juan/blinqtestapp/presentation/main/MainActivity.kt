package alvarez.juan.blinqtestapp.presentation.main

import alvarez.juan.blinqtestapp.data.network.model.Request
import alvarez.juan.blinqtestapp.databinding.ActivityMainBinding
import alvarez.juan.blinqtestapp.presentation.EnterRequestDialog
import alvarez.juan.blinqtestapp.presentation.OnButtonClickRequestDialog
import alvarez.juan.blinqtestapp.util.observe
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState)
        setUpObservers()

        val context = applicationContext

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val onButtonClickRequestDialog: OnButtonClickRequestDialog = object : OnButtonClickRequestDialog {
            override fun onClick(name: String, email: String) {
                viewModel.postRequest(Request(name, email))
            }
        }

        binding.button.setOnClickListener {

            val alert = EnterRequestDialog()
            alert.showEnterRequestDialog(this, context, onButtonClickRequestDialog)

        }
    }

    private fun setUpObservers() {
        observe(viewModel.requestInvitation, ::onPostRequest)
    }

    private fun onPostRequest(requestResult: String) {
        Toast.makeText(
            applicationContext,
            requestResult,
            Toast.LENGTH_SHORT
        ).show()
    }
}