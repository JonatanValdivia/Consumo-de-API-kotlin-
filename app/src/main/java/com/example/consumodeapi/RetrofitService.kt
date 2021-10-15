package com.example.consumodeapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    // Método que será responsável por chamar a API
    // https://viacep.com.br/ws/${}/json/
    @GET("{CEP}/json/") //Esse @get tem uma estrutura
    fun getCEP(@Path("CEP") cep : String) : Call<Cep>
}