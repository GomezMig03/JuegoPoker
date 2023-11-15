package com.example.juegopoker

import androidx.compose.runtime.structuralEqualityPolicy

fun EsMayor(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): Int {
    return maxOf(c1, c2, c3, c4, c5)
}

fun HayPareja(vararg numeros: Int): Boolean {
    val numerosUnicos = numeros.toSet()
    return numeros.size != numerosUnicos.size
}

fun HayDoblePareja(vararg numeros: Int): Boolean {
    val numerosUnicos = numeros.toSet()
    return numeros.size <4;
}

fun HayTrio(vararg numeros: Int): Boolean{
    val contador = mutableMapOf<Int, Int>()
    for (numero in numeros) {
        contador[numero] = contador.getOrDefault(numero, 0) + 1
    }
    return contador.any { it.value >= 3 }
}

fun HayEscalera(vararg numeros: Int): Boolean{
    var contador1=0;
    var contador2=13;
    var nums: List<Int> = numeros.toList().sorted()
    var n1=nums[0]
    for (i in nums){
        if ((i==n1) || (i-n1%contador2==0)) {
            contador1++
            }
        contador2++
    }
    return contador1>=5
}

fun HayColor(vararg numeros: Int): Boolean{
    val clubsRange = 1..13
    val spadesRange = 14..26
    val heartsRange = 27..39
    val diamondsRange = 40..52

    return numeros.all { it in clubsRange || it in spadesRange || it in heartsRange || it in diamondsRange }
}

fun HayFull(vararg numeros: Int): Boolean{
    val contador = mutableMapOf<Int, Int>()
    for (numero in numeros) {
        contador[numero] = contador.getOrDefault(numero, 0) + 1
    }
    return (contador.any { it.value >= 3 } && contador.any { it.value == 2 })
}

fun HayPoker(vararg numeros: Int): Boolean{
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

fun HayEscColor(vararg numeros: Int): Boolean{

}