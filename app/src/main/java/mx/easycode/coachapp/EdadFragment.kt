package mx.easycode.coachapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.easycode.coachapp.databinding.FragmentEdadBinding

class EdadFragment : Fragment() {

    private lateinit var binding: FragmentEdadBinding
    private var edad: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEdadBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val unidadesEdad = arrayOf("Años")
        binding.npUnidadesEdad.minValue = 1
        binding.npUnidadesEdad.maxValue = unidadesEdad.size
        binding.npUnidadesEdad.displayedValues = unidadesEdad
        binding.npUnidadesEdad.value = 1

        binding.npEdadAnios.value = 18
        edad = 18

        binding.btnContinuar.setOnClickListener {

            edad = binding.npEdadAnios.value
            findNavController().navigate(R.id.action_edadFragment_to_creandoPlanFragment)

        }

    }

    override fun onResume() {
        super.onResume()
        binding.npEdadAnios.value = edad
    }

}