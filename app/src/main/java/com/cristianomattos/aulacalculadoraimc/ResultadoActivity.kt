package com.cristianomattos.aulacalculadoraimc

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    lateinit var textPeso: TextView
    lateinit var textAltura: TextView
    lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)


        val bundle = intent.extras
        if(bundle != null) {

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado $peso Kg"
            textAltura.text = "Altura informada $altura m"

            val imc = peso/ (altura * altura)
            val stringFormatada = String.format("%.1f", imc)

            val resultado = if(imc < 18.5)
                "Abaixo do peso"
            else if(imc in 18.5 .. 24.9)
                "Normal"
            else if(imc in 25.0 .. 29.9)
                "Acima do peso"
            else
                "Obesidade"

            textResultado.text = "$resultado\nIMC = $stringFormatada"
        }

    }
}