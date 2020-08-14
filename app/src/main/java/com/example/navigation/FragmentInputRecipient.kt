package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigation.ViewModel.ViewModelTransfer
import kotlinx.android.synthetic.main.fragment_input_recipient.*
import kotlin.toString as toString1


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentInputRecipient.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentInputRecipient : Fragment(),View.OnClickListener {

    val viewModelTransfer by activityViewModels<ViewModelTransfer>()

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        inputRecipient.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v){
           inputRecipient->{
              // val bundle= bundleOf("Name" to recipient_name_text.text.toString())
               //navController.navigate(R.id.action_fragmentInputRecipient_to_fragmentInputAmount,bundle)

                viewModelTransfer.nama.value = namaPengirim.text?.toString()
               viewModelTransfer.acount_number.value=recipientAccount.text?.toString()
               viewModelTransfer.nama_bank.value=bankName.selectedItem.toString()
                println(bankName.selectedItem.toString())
               navController.navigate(R.id.action_fragmentInputRecipient_to_fragmentInputAmount)
           }
       }
    }
}