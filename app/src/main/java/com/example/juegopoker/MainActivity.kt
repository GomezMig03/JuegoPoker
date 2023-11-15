package com.example.juegopoker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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

data class Carta(val tipo: String, val valor: Int)

//Juego de poker
@Composable
fun PokerMainGame(modifier:Modifier=Modifier){
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //stats
        stats()
        Spacer(
            modifier
                .height(125.dp)
        )
        Text(
            text="asd:",
            modifier
                .size(16.dp)
                .align(alignment = CenterHorizontally)
                .padding(top = 16.dp)
        )
        //Primera fila con las cartas que vamos a estar viendo
        CartasComunitarias()
        Spacer(
            modifier.height(95.dp)
        )
        //Segunda fila con las cartas de nuestra mano
        mano()
        Spacer(
            modifier.height(64.dp)
        )
        //Tercera fila con las opciones(botones) que tenemos, Call, Raise, Fold, Check, All-In
        botones()
    }
}

@Composable
fun CartasComunitarias(modifier:Modifier=Modifier){
    Row(
    ) {
        //Flop
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = "reverso",
            modifier
                .size(130.dp)
        )
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = "reverso",
            modifier
                .size(130.dp)
        )
        Spacer(
            modifier=Modifier
                .width(1.dp)
        )
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = "reverso",
            modifier
                .size(130.dp)
        )
        Spacer(
            modifier=Modifier
                .width(1.dp)
        )
    }
}

@Composable
fun stats(modifier: Modifier=Modifier){
    var fichas=50000
    Row(){
        Spacer(
            modifier
                .width(275.dp)
        )
        Text(
            text= stringResource(id = R.string.Coins)+fichas
        )
    }
}

@Composable
fun mano(modifier: Modifier=Modifier) {
    Row(
    ) {
        //Flop
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = "reverso",
            modifier
                .size(200.dp)
        )
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = "reverso",
            modifier
                .size(200.dp)
        )
    }
}

@Composable
fun botones(modifier: Modifier=Modifier) {
    Row(
    ){
        Button(onClick = { /*TODO*/ },
            modifier = modifier.size(100.dp)
        ) {
            Text(text= stringResource(id = R.string.call))
        }
        Spacer(
            modifier
                .width(16.dp)
        )
        Button(onClick = { /*TODO*/ },
            modifier = modifier.size(100.dp)
        ) {
            Text(text= stringResource(id = R.string.allIn))
        }
        Spacer(
            modifier.width(16.dp)
        )
        Button(onClick = { /*TODO*/ },
            modifier = modifier.size(100.dp)
        ) {
            Text(text= stringResource(id = R.string.fold))
        }
    }
}

