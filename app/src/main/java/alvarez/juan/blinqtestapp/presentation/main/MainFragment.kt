package alvarez.juan.blinqtestapp.presentation.main

import androidx.fragment.app.Fragment
import alvarez.juan.blinqtestapp.R
import alvarez.juan.blinqtestapp.data.network.model.Request
import alvarez.juan.blinqtestapp.databinding.FragmentMainBinding
import alvarez.juan.blinqtestapp.presentation.EnterRequestDialog
import alvarez.juan.blinqtestapp.presentation.OnButtonClickRequestDialog
import alvarez.juan.blinqtestapp.presentation.congratulations.CongratulationsFragment
import alvarez.juan.blinqtestapp.util.hideView
import alvarez.juan.blinqtestapp.util.observe
import alvarez.juan.blinqtestapp.util.showView
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()

        binding = FragmentMainBinding.bind(view)

        val onButtonClickRequestDialog: OnButtonClickRequestDialog = object : OnButtonClickRequestDialog {
            override fun onClick(name: String, email: String) {
                binding.linearLayoutLoading.showView()
                binding.linearLayoutContent.hideView()
                viewModel.postRequest(Request(name, email))
            }
        }

        binding.button.setOnClickListener {
            val alert = EnterRequestDialog()
            alert.showEnterRequestDialog(requireActivity(), requireContext(), onButtonClickRequestDialog)
        }
    }

    private fun setUpObservers() {
        observe(viewModel.requestInvitation, ::onPostRequest)
    }

    private fun onPostRequest(requestResult: String) {
        val alertDialog = AlertDialog.Builder(requireContext())

        if (requestResult == "success") {
            alertDialog.apply {
                setIcon(R.drawable.happy_face_icon)
                setTitle(R.string.request_success_popup_title)
                setMessage(R.string.request_success_popup_text)
                setPositiveButton(R.string.request_success_popup_button) { _, _ ->
                    val transaction = requireActivity().supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainer, CongratulationsFragment::class.java, null)
                    transaction.commit()
                }
            }.create().show()

            binding.linearLayoutLoading.hideView()
            binding.linearLayoutContent.showView()
        }

        if (requestResult == "Error") {
            alertDialog.apply {
                setIcon(R.drawable.error_icon)
                setTitle(R.string.request_error_popup_title)
                setMessage(R.string.request_error_popup_text)
                setPositiveButton(R.string.request_success_popup_button) { _, _ ->
                }
            }.create().show()

            binding.linearLayoutLoading.hideView()
            binding.linearLayoutContent.showView()
        }
    }
}