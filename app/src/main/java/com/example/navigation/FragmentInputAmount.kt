package com.example.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_input_amount.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentInputAmount.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentInputAmount : Fragment(), View.OnClickListener {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        send_Amount.setOnClickListener(this)
    }
    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        account_name.text="TO : ${arguments?.getString("Name")} "
    }

    override fun onClick(v: View?) {
       when(v){
           send_Amount->{
               val bundle= bundleOf("nama_done" to account_name.text.toString(),"amount_done" to recipient_Amount.text.toString())
               navController.navigate(R.id.action_fragmentInputAmount_to_fragmentConfirmation,bundle)
           }
       }
    }


}