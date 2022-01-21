package mx.easycode.coachapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import mx.easycode.coachapp.databinding.FragmentCondicionFisicaBinding

class CondicionFisicaFragment : Fragment() {

    private lateinit var binding: FragmentCondicionFisicaBinding
    private var nivelCondicionFisica = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCondicionFisicaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPrincipiante.setOnClickListener {

            seleccionarNivelCondicionFisica(resources.getString(R.string.condicion_principiante))

        }

        binding.btnIntermedio.setOnClickListener {

            seleccionarNivelCondicionFisica(resources.getString(R.string.condicion_intermedio))

        }

        binding.btnAvanzado.setOnClickListener {

            seleccionarNivelCondicionFisica(resources.getString(R.string.condicion_avanzado))

        }

        binding.btnContinuar.setOnClickListener {

            if(nivelCondicionFisica.isNullOrEmpty()){

                Toast.makeText(requireContext(),"Debe seleccionar un Nivel de condición física para continuar!", Toast.LENGTH_SHORT).show()

            } else {

                findNavController().navigate(R.id.action_condicionFisicaFragment_to_pesoActualFragment)

            }

        }

    }

    fun seleccionarNivelCondicionFisica(condicion: String){

        nivelCondicionFisica = condicion

        binding.btnPrincipiante.background = resources.getDrawable(R.drawable.diselected_button_style)
        binding.btnIntermedio.background = resources.getDrawable(R.drawable.diselected_button_style)
        binding.btnAvanzado.background = resources.getDrawable(R.drawable.diselected_button_style)

        when(condicion){

            resources.getString(R.string.condicion_principiante) -> binding.btnPrincipiante.background = resources.getDrawable(R.drawable.selected_button_style)
            resources.getString(R.string.condicion_intermedio) -> binding.btnIntermedio.background = resources.getDrawable(R.drawable.selected_button_style)
            resources.getString(R.string.condicion_avanzado) -> binding.btnAvanzado.background = resources.getDrawable(R.drawable.selected_button_style)

        }

    }

    override fun onResume() {
        super.onResume()
        if(nivelCondicionFisica.isNotEmpty()){
            seleccionarNivelCondicionFisica(nivelCondicionFisica)
        }
    }

}