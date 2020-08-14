package com.example.navigation.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelTransfer : ViewModel() {
    var nama  = MutableLiveData("")
    var amount_send = MutableLiveData("")
    var acount_number = MutableLiveData("")
    var nama_bank= MutableLiveData("")


}