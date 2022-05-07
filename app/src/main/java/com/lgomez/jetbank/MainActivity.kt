package com.lgomez.jetbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lgomez.jetbank.ui.theme.JetbankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginForm()
        }
    }

}

@Composable
fun Screen(content: @Composable () -> Unit) {
    JetbankTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
            content = content
        )
    }
}

@Preview
@Composable
private fun LoginForm() {
    Screen {
        //Box, como el frame layout- usa el surface
        //Column: linear layout vertical
        //Row: linear layout horizontal
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
        ) {
            //concepto Slot API (API basada en huecos)
            UserField()
            PasswordField()
            LoginButton()
        }
    }
}

@Composable
private fun UserField() {
    //Jetpack compose funciona con un sistema llamado recomposición (el código se va a re ejecutar)
    //Para poder mantener el estado hay que usar una mutableStateOf()
    //by: delegado, podemos estar cambiando el estado sin tener que usar el .value
    //directamente pasamos valor a la propiedad y automáticamente lo guarda en el .value del state
    var user by remember { mutableStateOf("") }

    OutlinedTextField(
        value = user,
        onValueChange = { user = it },
        label = { Text(text = "User") }
    )
}


//state hosting: o elevación de estado
//el componente era state less porque gestionaba su propio estado
//ahora le pedimos que delegue su estado en el componente superior

@Composable
private fun PasswordField() {
    var pass by remember { mutableStateOf("")}
    OutlinedTextField(
        value = pass,
        onValueChange = { pass = it },
        label = { Text(text = "Password") }
    )
}

@Composable
private fun LoginButton() {
    Button(onClick = { /*TODO*/ }) {
        //el button nos está dando un RowScope, por lo que los pone en una fila
        Text(text = "Login")
        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)

    }
}
