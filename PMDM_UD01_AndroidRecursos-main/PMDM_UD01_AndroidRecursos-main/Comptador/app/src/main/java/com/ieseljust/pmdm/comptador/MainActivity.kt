package com.ieseljust.pmdm.comptador


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ieseljust.pmdm.comptador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var comptador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Referencia al TextView
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)

        // Inicialitzem el TextView amb el comptador a 0
        binding.textViewComptador.text = comptador.toString()

        // Referencia al botón
        val btAdd = findViewById<Button>(R.id.btAdd)
        val btReset = findViewById<Button>(R.id.btReset)
        val btResta = findViewById<Button>(R.id.btResta)

        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        btAdd.setOnClickListener {
            comptador++
            // textViewContador.text = comptador.toString()
            binding.textViewComptador.text = comptador.toString()
        }
        // Botón Resta
        btResta.setOnClickListener {
            comptador--
            binding.textViewComptador.text = comptador.toString()
        }

        // Botón Reset
        btReset.setOnClickListener {
            comptador = 0
            binding.textViewComptador.text = comptador.toString()
        }

    }
    override fun onSaveInstanceState(estat: Bundle) {
        super.onSaveInstanceState(estat)
        // Codi per a guardar l'estat
        estat.putInt("Contador", comptador)
    }

    override fun onRestoreInstanceState(estat: Bundle) {
        super.onRestoreInstanceState(estat)
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)
        // Codi per a guardar l'estat
        comptador=estat.getInt("Contador")
        binding.textViewComptador.text = comptador.toString()
    }
}