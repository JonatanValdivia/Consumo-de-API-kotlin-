package com.example.consumodeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    //Variaveis da implementação de buscar o cep
    lateinit var buttonBuscar: Button
    lateinit var textVIewEndereco: TextView
    lateinit var editText: EditText

    //Variaveis da implementação de buscar as ruas

    lateinit var buttonBuscarRuas: Button
    lateinit var etSiglaEstado: EditText
    lateinit var etCidade: EditText
    lateinit var etRua: EditText
    lateinit var textViewRuas: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBuscar = findViewById(R.id.btn_buscar_cep)
        textVIewEndereco = findViewById(R.id.tv_response)
        editText = findViewById(R.id.et_cep)

        buttonBuscarRuas = findViewById(R.id.btn_buscar_ruas);
        etSiglaEstado = findViewById(R.id.et_estado)
        etCidade = findViewById(R.id.et_cidade)
        etRua = findViewById(R.id.et_rua)
        textViewRuas = findViewById(R.id.text_response)

        buttonBuscar.setOnClickListener {

            //Obter uma instância da conexão com o back-end
            val remote = RetrofitFactory().retrofitService()

            //Criar uma chamada para o endpoint /cep/json
            val call: Call<Cep> = remote.getCEP(editText.text.toString())

            //Executar a chamada paa a api
            call.enqueue(object : Callback<Cep> { //função lambda -> arow function
                override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                    val cep = response.body()

                }

                override fun onFailure(call: Call<Cep>, t: Throwable) {
                    Log.i("cep", t.message.toString())
                }

            })

        }

        buttonBuscarRuas.setOnClickListener {

        }

    }
}