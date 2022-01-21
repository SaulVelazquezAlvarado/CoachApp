package mx.easycode.coachapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import mx.easycode.coachapp.databinding.FragmentGeneroBinding

class GeneroFragment : Fragment() {

    private lateinit var binding: FragmentGeneroBinding
    private var generoSeleccionado: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGeneroBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGeneroFemenino.setOnClickListener {

            seleccionarGenero(resources.getString(R.string.genero_femenino))

        }

        binding.btnGeneroMasculino.setOnClickListener {

            seleccionarGenero(resources.getString(R.string.genero_masculino))

        }

        binding.btnContinuar.setOnClickListener {

            if(generoSeleccionado.isNullOrEmpty()){

                Toast.makeText(requireContext(),"Debe seleccionar su género para continuar!",Toast.LENGTH_SHORT).show()

            } else {

                findNavController().navigate(R.id.action_generoFragment_to_objetivoFragment)

            }

        }


    }

    fun seleccionarGenero(genero: String){

        generoSeleccionado = genero

        binding.btnGeneroMasculino.background = resources.getDrawable(R.drawable.diselected_button_style)
        binding.btnGeneroFemenino.background = resources.getDrawable(R.drawable.diselected_button_style)

        if(genero == resources.getString(R.string.genero_masculino)){
            binding.btnGeneroMasculino.background = resources.getDrawable(R.drawable.selected_button_style)
        }else{
            binding.btnGeneroFemenino.background = resources.getDrawable(R.drawable.selected_button_style)
        }

    }

    override fun onResume() {
        super.onResume()
        if(generoSeleccionado.isNotEmpty()){

            seleccionarGenero(generoSeleccionado)

        }
    }

}