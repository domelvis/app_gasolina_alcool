package br.gov.sp.etec.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.com.appgasolinaoualcool.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var textInputAlcool : TextInputLayout
    private lateinit var textInputGasolina : TextInputLayout

    private lateinit var textEditAlcool : TextInputEditText
    private lateinit var textEditGasolina : TextInputEditText

    private lateinit var btnCalcular : Button

    private lateinit var textResultado : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarElementosInterface()
        btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }
    }

    private fun calcularMelhorPreco() {
        val precoAlcool   = textEditAlcool.text.toString()
        val precoGasolina = textEditGasolina.text.toString()

        var resultadoValidacao = validarCampo(precoAlcool, precoGasolina)
        if(resultadoValidacao){
            val precoAlcoolNumero       = precoAlcool.toDouble();
            val precoGasolinaNumero     = precoGasolina.toDouble();
            val resultado               = precoAlcoolNumero / precoGasolinaNumero
            if(resultado > 0.7){
                textResultado.text = "Melhor usar Gasolina";
            }else{
                textResultado.text = "Melhor usar Álcool";
            }
        }
    }

    private fun validarCampo(precoAlcool: String, precoGasolina: String) : Boolean{
        textInputAlcool.error = null
        textInputGasolina.error = null
        if(precoAlcool.isEmpty()){
            textInputAlcool.error = "Digite o preço do alcool"
            return false
        }else if(precoGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preço da gasolina"
            return false
        }else{
            return  true
        }
    }


    private fun inicializarElementosInterface() {
        textInputAlcool   = findViewById(R.id.textInputAlcool)
        textInputGasolina = findViewById(R.id.textInputGasolina)

        textEditAlcool    = findViewById(R.id.textEditAlcool)
        textEditGasolina  = findViewById(R.id.textEditGasolina)

        btnCalcular       = findViewById(R.id.btnCalcular)

        textResultado     = findViewById(R.id.textResultado)
    }
}