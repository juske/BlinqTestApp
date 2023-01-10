package alvarez.juan.blinqtestapp.presentation.precancel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import alvarez.juan.blinqtestapp.R
import alvarez.juan.blinqtestapp.databinding.FragmentPrecancelBinding
import alvarez.juan.blinqtestapp.presentation.cancel.CancelFragment
import androidx.appcompat.app.AlertDialog

class PreCancelFragment: Fragment(R.layout.fragment_precancel) {

    private lateinit var binding: FragmentPrecancelBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPrecancelBinding.bind(view)

        binding.button.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext())
            alertDialog.apply {
                setIcon(R.drawable.ic_baseline_warning_24)
                setTitle(R.string.cancel_request_popup_title)
                setMessage(R.string.cancel_request_popup_text)
                setPositiveButton(R.string.cancel_request_popup_button) { _, _ ->
                    val transaction = requireActivity().supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainer, CancelFragment::class.java, null)
                    transaction.commit()
                }
                setNegativeButton(R.string.keep_request_popup_button) { _, _ ->

                }
            }.create().show()
        }
    }
}
