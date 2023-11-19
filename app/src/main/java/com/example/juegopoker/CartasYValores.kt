package com.example.juegopoker

fun getCartaPorNumero(num: Number=0): Int {
    val imageResource =
        when (num) {
            1 -> R.drawable.c1
            2 -> R.drawable.c2
            3 -> R.drawable.c3
            4 -> R.drawable.c4
            5 -> R.drawable.c5
            6 -> R.drawable.c6
            7 -> R.drawable.c7
            8 -> R.drawable.c8
            9 -> R.drawable.c9
            10 -> R.drawable.c10
            11 -> R.drawable.cj
            12 -> R.drawable.cq
            13 -> R.drawable.ck
            14 -> R.drawable.s1
            15 -> R.drawable.s2
            16 -> R.drawable.s3
            17 -> R.drawable.s4
            18 -> R.drawable.s5
            19 -> R.drawable.s6
            20 -> R.drawable.s7
            21 -> R.drawable.s8
            22 -> R.drawable.s9
            23 -> R.drawable.s10
            24 -> R.drawable.sj
            25 -> R.drawable.sq
            26 -> R.drawable.sk
            27 -> R.drawable.h1
            28 -> R.drawable.h2
            29 -> R.drawable.h3
            30 -> R.drawable.h4
            31 -> R.drawable.h5
            32 -> R.drawable.h6
            33 -> R.drawable.h7
            34 -> R.drawable.h8
            35 -> R.drawable.h9
            36 -> R.drawable.h10
            37 -> R.drawable.hj
            38 -> R.drawable.ch
            39 -> R.drawable.hk
            40 -> R.drawable.d1
            41 -> R.drawable.d2
            42 -> R.drawable.d3
            43 -> R.drawable.d4
            44 -> R.drawable.d5
            45 -> R.drawable.d6
            46 -> R.drawable.d7
            47 -> R.drawable.d8
            48 -> R.drawable.d9
            49 -> R.drawable.d10
            50 -> R.drawable.dj
            51 -> R.drawable.dq
            52 -> R.drawable.dk
            53 -> R.drawable.base
            else -> R.drawable.back
        }
    return imageResource
}

fun cartaToString(num: Int): String {
    var carta=""+ getNombreCarta(num)
    val clubsRango = 1..13
    val spadesRango = 14..26
    val heartsRango = 27..39
    val diamondsRango = 40..52
    carta+=when (num) {
        in clubsRango -> " de treboles"
        in spadesRango -> " de picas"
        in heartsRango -> " de corazones"
        in diamondsRango -> " de diamantes"
        else -> null
    }
    return carta
}

fun getNombreCarta(num: Int): String {
    when (getCartaValor(num)) {
        1 -> return "uno"
        2 -> return "dos"
        3 -> return "tres"
        4 -> return "cuatro"
        5 -> return "cinco"
        6 -> return "seis"
        7 -> return "siete"
        8 -> return "ocho"
        9 -> return "nueve"
        10 -> return "diez"
        11 -> return "sota"
        12 -> return "reina"
        13 -> return "rey"
        else -> return "null"
    }
}
fun getCartaValor(num: Int): Int {
    val clubsRango = 1..13
    val spadesRango = 14..26
    val heartsRango = 27..39
    val diamondsRango = 40..52
    when (num) {
        in clubsRango -> return clubsRango.indexOf(num)+1
        in spadesRango -> return spadesRango.indexOf(num)+1
        in heartsRango -> return heartsRango.indexOf(num)+1
        in diamondsRango -> return diamondsRango.indexOf(num)+1
        else -> return 0
    }
}


fun getCartaAleatoria(vararg numeros: Int): Int {
    var x: Int
    do {
        x=(1..52).random()
    } while (x in numeros)
    return x
}

fun getCombinacion(c1: Int,c2: Int,c3: Int,c4: Int,c5: Int): String {
    if (hayEscaleraReal(c1, c2, c3, c4, c5)) {
        return "Escalera Real"
    } else if (hayEscColor(c1, c2, c3, c4, c5)) {
        return "Ecalera de Color"
    } else if (hayPoker(c1, c2, c3, c4, c5)) {
        return "Poker"
    } else if (hayFull(c1, c2, c3, c4, c5)) {
        return "Full"
    } else if (hayColor(c1, c2, c3, c4, c5)) {
        return "Color"
    } else if (hayEscalera(c1, c2, c3, c4, c5)) {
        return "Escalera"
    } else if (hayTrio(c1, c2, c3, c4, c5)) {
        return "Trio"
    } else if (hayDoblePareja(c1, c2, c3, c4, c5)) {
        return "Doble pareja"
    } else if (hayPareja(c1, c2, c3, c4, c5)) {
        return "Pareja"
    } else {
        val x= esMayor(c1, c2, c3, c4, c5)
        return "Carta mayor: $x"
    }
}