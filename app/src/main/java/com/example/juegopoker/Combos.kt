package com.example.juegopoker

import androidx.compose.runtime.structuralEqualityPolicy

fun esMayor(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): Int {
    return maxOf(c1, c2, c3, c4, c5)
}

fun hayPareja(vararg numeros: Int): Boolean {
    val numerosUnicos = numeros.toSet()
    return numeros.size != numerosUnicos.size
}

fun hayDoblePareja(vararg numeros: Int): Boolean {
    val numerosUnicos = numeros.toSet()
    return numeros.size <4;
}

fun hayTrio(vararg numeros: Int): Boolean{
    val contador = mutableMapOf<Int, Int>()
    for (numero in numeros) {
        contador[numero] = contador.getOrDefault(numero, 0) + 1
    }
    return contador.any { it.value >= 3 }
}

fun hayEscalera(vararg numeros: Int): Boolean{
    var contador1=0
    var contador2=13
    var nums: List<Int> = numeros.toList().sorted()
    var n1=nums[0]
    for (i in nums){
        if ((i==n1) || (i-n1%contador2==0) || (i-n1-(contador2-13)==0 && hayColor(n1, i))) {
            contador1++
            }
        contador2++
    }
    return contador1>=5
}

fun hayColor(vararg numeros: Int): Boolean{
    val clubsRango = 1..13
    val spadesRango = 14..26
    val heartsRango = 27..39
    val diamondsRango = 40..52

    return numeros.all { it in clubsRango || it in spadesRango || it in heartsRango || it in diamondsRango }
}

fun hayFull(vararg numeros: Int): Boolean{
    val contador = mutableMapOf<Int, Int>()
    for (numero in numeros) {
        contador[numero] = contador.getOrDefault(numero, 0) + 1
    }
    return (contador.any { it.value >= 3 } && contador.any { it.value == 2 })
}

fun hayPoker(vararg numeros: Int): Boolean{
    var contador=0;
    var nums: List<Int> = numeros.toList().sorted()
    for (num1 in nums) {
        for (num2 in numeros) {
            if((num1-num2)%13==0) {
                contador++;
            }
        }
        if (contador>=4) {
            return true
        }
            contador=0
    }
    return false
}

fun hayEscColor(vararg numeros: Int): Boolean{
    return (hayEscalera() && hayColor())
}

fun hayEscaleraReal(vararg numeros: Int): Boolean {
    val numerosLista = numeros.toList()
    val clubsReal  = listOf(1, 10, 11, 12, 13)
    val spadesReal = listOf(14, 23, 24, 25, 26)
    val heartsReal = listOf(27, 36, 37, 38, 39)
    val diamReal = listOf(40, 49, 50, 51, 52)

    return (numerosLista.containsAll(clubsReal) || numerosLista.containsAll(spadesReal) ||
            numerosLista.containsAll(heartsReal) || numerosLista.containsAll(diamReal))
}