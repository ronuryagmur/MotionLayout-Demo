package com.pluvia.material.chameleoncards.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel() {
    private val _snappedEventItemPosition = MutableLiveData(0)
    val snappedEventItemPosition = _snappedEventItemPosition

    private val _onEventItemClicked = MutableLiveData<Boolean>()
    val onEventItemClicked = _onEventItemClicked

    fun setSnappedEventItemPosition(position: Int){
        if (position != _snappedEventItemPosition.value && position >= 0)
            _snappedEventItemPosition.value = position
    }

    fun setOnEventItemClicked(value: Boolean){
        _onEventItemClicked.value = value
    }
}