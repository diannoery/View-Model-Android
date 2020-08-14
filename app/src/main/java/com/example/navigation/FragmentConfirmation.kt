package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigation.ViewModel.ViewModelTransfer
import kotlinx.android.synthetic.main.fragment_confirmation.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentConfirmation.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentConfirmation : Fragment(),View.OnClickListener {
    lateinit var navController: NavController
    val viewModelTransfer by activityViewModels<ViewModelTransfer>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        done_recipient.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       // name_done.text="Sent To ${arguments?.getString("nama_done")}"
        name_done.text="Sent To ${viewModelTransfer.nama.value}"
        AcountNumber.text="${viewModelTransfer.acount_number.value}"
        //amount_done.text="Rp.${arguments?.getString("amount_done")}"
        amount_done.text="Rp.${viewModelTransfer.amount_send.value}"
        bank.text="${viewModelTransfer.nama_bank.value}"
    }

    override fun onClick(v: View?) {
      when(v){
          done_recipient->{
              navController.navigate(R.id.action_fragmentConfirmation_to_fragmentInputRecipient)
          }
      }
    }


}