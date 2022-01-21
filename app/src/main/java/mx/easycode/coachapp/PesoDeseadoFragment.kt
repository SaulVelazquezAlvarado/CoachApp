package mx.easycode.coachapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.easycode.coachapp.databinding.FragmentPesoActualBinding
import mx.easycode.coachapp.databinding.FragmentPesoDeseadoBinding

class PesoDeseadoFragment : Fragment() {

    private lateinit var binding: FragmentPesoDeseadoBinding
    private var pesoUnits: Int = 50
    private var pesoDecimals: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPesoDeseadoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.npPesoUnidades.minValue = 1
        binding.npPesoUnidades.maxValue = 400
        binding.npPesoUnidades.setOnValueChangedListener { picker, oldVal, newVal ->

            binding.tvSeleccionPesoActual.text = " $newVal.${binding.npPesoDecimales.value} Kg"

        }

        binding.npPesoDecimales.minValue = 0
        binding.npPesoDecimales.maxValue = 9
        binding.npPesoDecimales.setOnValueChangedListener { picker, oldVal, newVal ->

            binding.tvSeleccionPesoActual.text = " ${binding.npPesoUnidades.value}.$newVal Kg"

        }

        val unidadesPeso = arrayOf("Kg")
        binding.npUnidadesPeso.minValue = 1
        binding.npUnidadesPeso.maxValue = unidadesPeso.size
        binding.npUnidadesPeso.displayedValues = unidadesPeso
        binding.npUnidadesPeso.setOnValueChangedListener { picker, oldVal, newVal ->

            binding.tvSeleccionPesoActual.text = " ${binding.npPesoUnidades.value}.${binding.npPesoDecimales.value} ${binding.npUnidadesPeso.value}"

        }

        binding.btnContinuar.setOnClickListener {

            pesoUnits = binding.npPesoUnidades.value
            pesoDecimals = binding.npPesoDecimales.value

            findNavController().navigate(R.id.action_pesoDeseadoFragment_to_alturaFragment)

        }

    }

    override fun onResume() {
        super.onResume()

        binding.npPesoUnidades.value = pesoUnits
        binding.npPesoDecimales.value = pesoDecimals

        binding.tvSeleccionPesoActual.text = "${pesoUnits}.${pesoDecimals} Kg"
    }

}