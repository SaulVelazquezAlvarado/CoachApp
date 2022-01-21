package mx.easycode.coachapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.combine
import mx.easycode.coachapp.databinding.FragmentAlturaBinding

class AlturaFragment : Fragment() {

    private lateinit var binding: FragmentAlturaBinding
    private var unidadesAltura = arrayOf("mts")
    private var alturaUnits: Int = 1
    private var alturaDecimals: Int = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlturaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.npUnidadesAltura.minValue = 1
        binding.npUnidadesAltura.maxValue = unidadesAltura.size
        binding.npUnidadesAltura.displayedValues = unidadesAltura

        binding.btnContinuar.setOnClickListener {

            alturaUnits = binding.npAlturaUnidades.value
            alturaDecimals = binding.npAlturaDecimales.value

            findNavController().navigate(R.id.action_alturaFragment_to_edadFragment)

        }

    }

    override fun onResume() {
        super.onResume()

        binding.npAlturaUnidades.value = alturaUnits
        binding.npAlturaDecimales.value = alturaDecimals

    }

}