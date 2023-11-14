package com.example.juegopoker

fun CardValues(c1: Int, c2: Int, c3: Int, c4: Int, c5: Int) {
    val mayor = maxOf(c1, c2, c3, c4, c5)

}

fun CartasRepetidas(vararg numeros: Int) {
    val numerosUnicos = numeros.toSet()


}

fun CartaPorNumero(num: Number=0): Int {
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