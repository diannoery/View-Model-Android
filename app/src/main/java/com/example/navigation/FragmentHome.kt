package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHome : Fragment(),View.OnClickListener {
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        transfer_button.setOnClickListener(this)
        balance_button.setOnClickListener(this)
        transaction_history_button.setOnClickListener(this)
    }

    override fun onClick(v:View){
        when(v){
            transfer_button->{navController.navigate(R.id.action_fragmentHome_to_transactionActivity)}
            balance_button->{navController.navigate(R.id.action_fragmentHome_to_fragmentBalance)}
            transaction_history_button->{navController.navigate(R.id.action_fragmentHome_to_fragmentHistory)}
        }
    }

}