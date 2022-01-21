package mx.easycode.coachapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.easycode.coachapp.databinding.FragmentPlanListoBinding

class PlanListoFragment : Fragment() {

    private lateinit var binding: FragmentPlanListoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlanListoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAccederMail.setOnClickListener {

            findNavController().navigate(R.id.action_planListoFragment_to_registrateFragment)

        }

    }

}