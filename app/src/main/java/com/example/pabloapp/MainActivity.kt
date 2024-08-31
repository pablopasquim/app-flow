package com.example.pabloapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pabloapp.ui.theme.PabloAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Calculadora()
            }
        }
    }

@Composable
fun Mensagem(){

    var nome = "Pablo"

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Aula 08")
        Text(text = "Bom dia, $nome!")
    }
}

@Composable
fun ExemploButton(){

    var texto by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        )
    {
        Text(text = "Clique no botão!")

        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {
            texto = if (texto.isEmpty()) "BOAAAAAAAAAAAAAAAAAA! Você clicou no botão!" else ""
        }) {
            Text(text = "Clique aqui!")
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(text = texto)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExemploTextField(){

    var nome by remember{ mutableStateOf("") }
    var texto by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = nome,
            onValueChange = { nome = it},
            label = {
                Text(text = "Digite seu nome")
            }
            )

        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {
            if(nome.isEmpty()){
                texto = "Digite um nome!"
            } else{
                texto = "Bom dia , $nome!"
            }
        }) {
            Text(text = "Mostrar o nome")
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(text = texto)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calculadora(){

    var n1 by remember { mutableStateOf("") }
    var n2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        TextField(value = n1,
            onValueChange = { n1 = it},
            label = {
                Text(text = "Informe um valor inteiro")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(25.dp))

        TextField(value = n2,
            onValueChange = { n2 = it},
            label = {
                Text(text = "Informe outro valor inteiro")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Button(onClick = {

                var valor1 = n1.toIntOrNull() ?: 0
                var valor2 = n2.toIntOrNull() ?: 0

                result = valor1 + valor2

            },
                ) {
                Text(text = "Somar")
            }

            Spacer(modifier = Modifier.height(5.dp))

            Button(onClick = {

                var valor1 = n1.toIntOrNull() ?: 0
                var valor2 = n2.toIntOrNull() ?: 0

                result = valor1 - valor2

            }) {
                Text(text = "Subtrair")
            }

            Spacer(modifier = Modifier.height(5.dp))

            Button(onClick = {

                var valor1 = n1.toIntOrNull() ?: 0
                var valor2 = n2.toIntOrNull() ?: 0

                if(valor1 == 0 || valor2 == 0){
                    result = 0
                } else
                    result = valor1 * valor2

            }) {
                Text(text = "Multiplicar")
            }

            Spacer(modifier = Modifier.height(5.dp))

            Button(onClick = {

                var valor1 = n1.toIntOrNull() ?: 0
                var valor2 = n2.toIntOrNull() ?: 0

                if(valor1 == 0 || valor2 == 0){
                    result = 0
                } else
                    result = valor1 / valor2

            }) {
                Text(text = "Dividir")
            }

            Spacer(modifier = Modifier.height(15.dp))

        }

        Text(
            text = "Resultado = $result",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
            )
    }

}

@Preview (showBackground = true)
@Composable
fun Call(){
    Calculadora()
}


