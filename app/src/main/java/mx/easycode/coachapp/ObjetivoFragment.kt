package mx.easycode.coachapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import mx.easycode.coachapp.databinding.FragmentObjetivoBinding

class ObjetivoFragment : Fragment() {

    private lateinit var binding: FragmentObjetivoBinding
    private var objetivoSeleccionado: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentObjetivoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPerderGrasa.setOnClickListener {

            seleccionarObjetivo(resources.getString(R.string.objetivo_grasa))

        }

        binding.btnAumentarMusculo.setOnClickListener {

            seleccionarObjetivo(resources.getString(R.string.objetivo_musculo))

        }

        binding.btnMantenerForma.setOnClickListener {

            seleccionarObjetivo(resources.getString(R.string.objetivo_forma))

        }

        binding.btnContinuar.setOnClickListener {

            if(objetivoSeleccionado.isNullOrEmpty()){

                Toast.makeText(requireContext(),"Debe seleccionar un objetivo para continuar!",Toast.LENGTH_SHORT).show()

            } else {

                findNavController().navigate(R.id.action_objetivoFragment_to_condicionFisicaFragment)

            }

        }

    }

    override fun onResume() {
        super.onResume()
        if(!objetivoSeleccionado.isNullOrEmpty()){
            seleccionarObjetivo(objetivoSeleccionado)
        }
    }

    fun seleccionarObjetivo(objetivo: String){

        objetivoSeleccionado = objetivo

        binding.btnMantenerForma.background = resources.getDrawable(R.drawable.diselected_button_style)
        binding.btnPerderGrasa.background = resources.getDrawable(R.drawable.diselected_button_style)
        binding.btnAumentarMusculo.background = resources.getDrawable(R.drawable.diselected_button_style)

        when(objetivo){
            resources.getString(R.string.objetivo_grasa) -> binding.btnPerderGrasa.background = resources.getDrawable(R.drawable.selected_button_style)
            resources.getString(R.string.objetivo_forma) -> binding.btnMantenerForma.background = resources.getDrawable(R.drawable.selected_button_style)
            resources.getString(R.string.objetivo_musculo) -> binding.btnAumentarMusculo.background = resources.getDrawable(R.drawable.selected_button_style)
        }

    }

}