package com.gauthier.nwcounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *Created by Alexandre GAUTHIER on 16/05/2023.
 */
class CounterViewModel : ViewModel() {
    // On crée un LiveData<Int> pour stocker la valeur du compteur
    private val _counter = MutableLiveData(0)
    val counter: LiveData<Int> = _counter

    // La méthode incrementCounter() incrémente la valeur du compteur
    fun incrementCounter() {
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }

    // La méthode resetCounter() réinitialise la valeur du compteur à 0
    fun resetCounter() {
        _counter.value = 0
    }
}