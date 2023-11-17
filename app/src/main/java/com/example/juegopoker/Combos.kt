package com.example.juegopoker

fun esMayor(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): String {
    val n1= getCartaValor(c1)
    val n2= getCartaValor(c2)
    val n3= getCartaValor(c3)
    val n4= getCartaValor(c4)
    val n5= getCartaValor(c5)

    return when (val maximo=maxOf(n1, n2, n3, n4, n5)) {
        13 -> {
            "Rey"
        }
        12 -> {
            "Reina"
        }
        11 -> {
            "Jota"
        }
        else -> {
            return "$maximo"
        }
    }
}

fun hayPareja(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): Boolean {
    val n1= getCartaValor(c1)
    val n2= getCartaValor(c2)
    val n3= getCartaValor(c3)
    val n4= getCartaValor(c4)
    val n5= getCartaValor(c5)
    val numeros= listOf(n1, n2, n3, n4, n5)
    val numerosUnicos = numeros.toSet()
    return numeros.size != numerosUnicos.size
}

fun hayDoblePareja(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): Boolean {
    val n1= getCartaValor(c1)
    val n2= getCartaValor(c2)
    val n3= getCartaValor(c3)
    val n4= getCartaValor(c4)
    val n5= getCartaValor(c5)
    val numeros= listOf(n1, n2, n3, n4, n5)
    val numerosUnicos = numeros.toSet()
    return numerosUnicos.size <4
}

fun hayTrio(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): Boolean{
    val n1= getCartaValor(c1)
    val n2= getCartaValor(c2)
    val n3= getCartaValor(c3)
    val n4= getCartaValor(c4)
    val n5= getCartaValor(c5)
    val numeros= listOf(n1, n2, n3, n4, n5)
    val contador = mutableMapOf<Int, Int>()
    for (numero in numeros) {
        contador[numero] = contador.getOrDefault(numero, 0) + 1
    }
    return contador.any { it.value >= 3 }
}

fun hayEscalera(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): Boolean{
    val n1= getCartaValor(c1)
    val n2= getCartaValor(c2)
    val n3= getCartaValor(c3)
    val n4= getCartaValor(c4)
    val n5= getCartaValor(c5)
    var numeros= listOf(n1, n2, n3, n4, n5)
    numeros=numeros.sorted()

    for (i in 1 until numeros.size) {
        if (numeros[i] != numeros[i - 1] + 1) {
            return false
        }
    }
    return true
}

fun hayColor(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): Boolean{
    val clubsRango = 1..13
    val spadesRango = 14..26
    val heartsRango = 27..39
    val diamondsRango = 40..52
    val rangos: List<IntRange> = listOf(clubsRango, spadesRango, heartsRango, diamondsRango)
    val numeros = listOf(c1, c2, c3, c4, c5)

    val primerRango = rangos.firstOrNull { rango -> numeros.all { rango.contains(it) } }
    return primerRango != null
}

fun hayFull(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): Boolean{
    val n1= getCartaValor(c1)
    val n2= getCartaValor(c2)
    val n3= getCartaValor(c3)
    val n4= getCartaValor(c4)
    val n5= getCartaValor(c5)
    val frecuenciaNumeros = mutableMapOf<Int, Int>()
    for (numero in listOf(n1, n2, n3, n4, n5)) {
        frecuenciaNumeros[numero] = frecuenciaNumeros.getOrDefault(numero, 0) + 1
    }

    return frecuenciaNumeros.containsValue(3) && frecuenciaNumeros.containsValue(2)
}

fun hayPoker(vararg numeros: Int): Boolean{
    var contador=0
    val nums: List<Int> = numeros.toList().sorted()
    for (num1 in nums) {
        for (num2 in numeros) {
            if((num1-num2)%13==0) {
                contador++
            }
        }
        if (contador>=4) {
            return true
        }
            contador=0
    }
    return false
}

fun hayEscColor(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): Boolean{
    return (hayEscalera(c1, c2, c3, c4, c5) && hayColor(c1, c2, c3, c4, c5))
}

fun hayEscaleraReal(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int): Boolean {
    val numerosLista = listOf(c1, c2, c3, c4, c5)
    val clubsReal  = listOf(1, 10, 11, 12, 13)
    val spadesReal = listOf(14, 23, 24, 25, 26)
    val heartsReal = listOf(27, 36, 37, 38, 39)
    val diamReal = listOf(40, 49, 50, 51, 52)

    return (numerosLista.containsAll(clubsReal) || numerosLista.containsAll(spadesReal) ||
            numerosLista.containsAll(heartsReal) || numerosLista.containsAll(diamReal))
}