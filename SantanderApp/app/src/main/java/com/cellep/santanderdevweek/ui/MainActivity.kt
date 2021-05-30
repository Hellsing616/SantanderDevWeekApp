package com.cellep.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cellep.santanderdevweek.R
import com.cellep.santanderdevweek.data.Conta
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaContaCliente()

        //throw RuntimeException("Test Crash")

    }

    private fun buscarContaContaCliente(){
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    fun bindOnView(conta : Conta){
        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia
        findViewById<TextView>(R.id.tv_conta).text = conta.numero
        findViewById<TextView>(R.id.tv_saldo_disponivel).text = conta.saldo
        findViewById<TextView>(R.id.tv_meu_dim_dim).text = conta.limite
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.tv_card_final_value).text = conta.cartao.numeroConta
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
                    R.id.item_3 ->{
                        Log.d("CLICK","click no item um")
                        true
                    }
            else -> super.onOptionsItemSelected(item)
        }

    }
}