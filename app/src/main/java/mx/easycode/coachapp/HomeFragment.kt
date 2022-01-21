package mx.easycode.coachapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import mx.easycode.coachapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var retos = ArrayList<RetoEnt>()
        retos.add(RetoEnt(1,"Sentadillas",""))
        retos.add(RetoEnt(2,"Abs Challenge",""))
        retos.add(RetoEnt(3,"Glúteo",""))

        val adapter: RetosAdapter = RetosAdapter(retos){

            Toast.makeText(requireContext(),"Mostrar Reto -> ${it.nombre}",Toast.LENGTH_SHORT).show()

        }

        binding.rvRetos.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.rvRetos.adapter = adapter

    }

}