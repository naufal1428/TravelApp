package com.example.travelapp

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.travelapp.databinding.FragmentTicketTypeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TicketTypeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TicketTypeFragment : Fragment() {

    private lateinit var binding: FragmentTicketTypeBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTicketTypeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            // data untuk Spinner
            val spinnerItems = arrayOf("First Class Ticket", "Business Class Ticket", "Economy Class Ticket")

            // adapter untuk Spinner
            val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerItems)

            // dropdown menu Spinner
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            // Menetapkan adapter ke Spinner
            spinnerTicketType.adapter = adapter

            btnBuy3.setOnClickListener{
                findNavController().apply {
                    previousBackStackEntry?.savedStateHandle?.set("ticket", spinnerTicketType.selectedItem.toString())
                }.navigateUp()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TicketTypeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TicketTypeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}