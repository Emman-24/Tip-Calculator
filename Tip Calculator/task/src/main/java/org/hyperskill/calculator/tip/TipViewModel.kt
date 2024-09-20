package org.hyperskill.calculator.tip

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TipViewModel: ViewModel() {

    private val _tipPercent = MutableLiveData<Int>()
    val tipPercent: LiveData<Int> = _tipPercent

    private val _billValue = MutableLiveData<Double>()
    val billValue: LiveData<Double> = _billValue

    private val _tipAmount = MutableLiveData<Double>()
    val tipAmount: LiveData<Double> = _tipAmount

    private val _total = MutableLiveData<Double>()
    val total: LiveData<Double> = _total

    init {
        _tipPercent.value = 15
        _billValue.value = 0.0
        _tipAmount.value = 0.0
        _total.value = 0.0
    }






}