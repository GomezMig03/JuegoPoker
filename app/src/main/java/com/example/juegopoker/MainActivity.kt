package com.example.juegopoker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.juegopoker.ui.theme.JuegoPokerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JuegoPokerTheme {
                JuegoPokerView()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JuegoPokerView() {
    PokerMainGame()
}

//Juego de poker
@Composable
fun PokerMainGame(modifier:Modifier=Modifier){
    var carta1 by remember { mutableStateOf(53)}
    var carta2 by remember { mutableStateOf(53)}
    var carta3 by remember { mutableStateOf(0)}
    var carta4 by remember { mutableStateOf(0)}
    var carta5 by remember { mutableStateOf(0)}
    var combinacion by remember { mutableStateOf("") }
    Row(modifier = modifier
        .fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center){
        Text(
            text = combinacion,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = CenterHorizontally
    ) {
        Spacer(
            modifier
                .height(125.dp)
        )
        //Primera fila con las cartas de la mano comunitaria
        Row {
            //Flop
            Image(
                painter = painterResource(getCartaPorNumero(carta3)),
                contentDescription = getNombreCarta(carta3),
                modifier
                    .size(130.dp)
            )
            Image(
                painter = painterResource(getCartaPorNumero(carta4)),
                contentDescription = getNombreCarta(carta4),
                modifier
                    .size(130.dp)
            )
            Spacer(
                modifier=Modifier
                    .width(1.dp)
            )
            Image(
                painter = painterResource(getCartaPorNumero(carta5)),
                contentDescription = "reverso",
                modifier
                    .size(130.dp)
            )
            Spacer(
                modifier=Modifier
                    .width(1.dp)
            )
        }
        Spacer(
            modifier.height(95.dp)
        )
        //Segunda fila con las cartas de nuestra mano
        var botonVisible by remember { mutableStateOf(true)}
        Box {
            Row {
                //Flop
                Image(
                    painter = painterResource(getCartaPorNumero(carta1)),
                    contentDescription = "carta",
                    modifier
                        .size(200.dp)
                )
                Image(
                    painter = painterResource(getCartaPorNumero(carta2)),
                    contentDescription = "carta",
                    modifier
                        .size(200.dp)
                )
            }
            if (botonVisible) {
                Spacer(
                    modifier=Modifier
                        .width(100.dp)
                )
                Button(onClick = {
                    carta1 = getCartaAleatoria()
                    carta2 = getCartaAleatoria(carta1)
                    botonVisible = false
                } ) {
                    Text(
                        text = stringResource(R.string.start),
                        fontSize = 24.sp
                    )

                }
            }
        }
        Spacer(
            modifier.height(64.dp)
        )
        //Tercera fila con las opciones(botones) que tenemos
        Row {
            Button(onClick = {
                if (!botonVisible) {
                    carta3=getCartaAleatoria(carta1, carta2)
                    carta4=getCartaAleatoria(carta1, carta2, carta3)
                    carta5=getCartaAleatoria(carta1, carta2, carta3, carta4)
                    combinacion= getCombinacion(carta1, carta2, carta3, carta4, carta5)
                }
            },
                modifier = modifier.size(100.dp)
            ) {
                Text(text= stringResource(id = R.string.call))
            }
            Spacer(
                modifier
                    .width(16.dp)
            )
            Spacer(
                modifier.width(32.dp)
            )
            Button(onClick = {
                if (!botonVisible) {
                    carta1 = getCartaAleatoria()
                    carta2 = getCartaAleatoria(carta1)
                    carta3 = 0
                    carta4 = 0
                    carta5 = 0
                }
                             },
                modifier = modifier.size(100.dp)
            ) {
                Text(text= stringResource(id = R.string.fold))
            }
        }
    }
}