package mx.easycode.coachapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.easycode.coachapp.databinding.FragmentRegistrateBinding

class RegistrateFragment : Fragment() {

    private lateinit var binding: FragmentRegistrateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnContinuar.setOnClickListener {

            var mainIntent = Intent(requireActivity(),MainActivity::class.java)
            startActivity(mainIntent)
            requireActivity().finish()

        }
    }

}