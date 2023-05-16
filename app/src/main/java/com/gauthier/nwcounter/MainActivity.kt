package com.gauthier.nwcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.gauthier.nwcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // On crée une instance de CounterViewModel qui sera utilisée pour stocker la valeur du compteur
    private lateinit var viewModel: CounterViewModel
    // On crée une instance de la classe auto-générée ActivityMainBinding qui contient les références aux vues du layout de l'activité
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // On utilise la méthode inflate() pour créer une instance de la classe ActivityMainBinding qui représente le layout de l'activité
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // On initialise l'instance de CounterViewModel à partir de la classe ViewModelProvider et on utilise la méthode get() pour obtenir une instance de CounterViewModel
        viewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        // On utilise l'instance de ActivityMainBinding pour récupérer les références aux vues du layout de l'activité
        binding.apply {
            // On initialise le TextView avec la valeur actuelle du compteur stockée dans le CounterViewModel
            counter.text = viewModel.counter.toString()

            // On configure le bouton d'incrémentation pour appeler la méthode incrementCounter() du CounterViewModel lorsqu'il est cliqué
            incrementButton.setOnClickListener {
                viewModel.incrementCounter()
            }

            // On configure le bouton de remise à zéro pour appeler la méthode resetCounter() du CounterViewModel lorsqu'il est appuyé longtemps
            resetButton.setOnLongClickListener {
                viewModel.resetCounter()
                true // on retourne true pour signaler qu'on a bien traité l'événement de long click
            }
        }

        // On utilise la méthode observe() pour observer les changements de la valeur du compteur stockée dans le CounterViewModel
        viewModel.counter.observe(this) { count ->
            // On met à jour le TextView avec la nouvelle valeur du compteur à chaque changement
            binding.counter.text = count.toString()
        }
    }
}
