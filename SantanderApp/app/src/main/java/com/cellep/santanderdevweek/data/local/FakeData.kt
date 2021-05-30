package com.cellep.santanderdevweek.data.local

import com.cellep.santanderdevweek.data.Cartao
import com.cellep.santanderdevweek.data.Cliente
import com.cellep.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData() : Conta {
        val cliente = Cliente("Alex Silva")
        val cartao = Cartao("12345-6")
        return Conta(
            "93393-6",
            "666-6",
            "R$ 3.674,03",
            "R$ 2.890,12",
            cliente,
            cartao
        )
    }
}