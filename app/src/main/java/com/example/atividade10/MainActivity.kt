package com.example.atividade10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash.finish
import com.example.atividade10.ui.theme.Atividade10Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent() {
            Atividade10Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Formulario { nome, telefone, endereco, cep, bairro ->
                        Toast.makeText(
                            this,
                            "Data: $nome, $telefone, $endereco, $cep, $bairro",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}

@Composable
fun Formulario(
    onFormSubmit: (String, String, String, String, String) -> Unit
) {
    var nome = remember { mutableStateOf("") } // Store form data in composable state
    var telefone = remember { mutableStateOf("") }
    var endereco = remember { mutableStateOf("") }
    var cep = remember { mutableStateOf("") }
    var bairro = remember { mutableStateOf("") }

    //Coluna:
    Column(
        Modifier.fillMaxWidth(),
        Arrangement.Center
    ) {

        //1ª linha:
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Center
        ) {

            //Título do app:
            Text(text = "Formulário", fontSize = 25.sp, modifier = Modifier.padding(10.dp))
        }

        // Espaçamento vertical:
        Spacer(modifier = Modifier.height(15.dp))

        //2ª linha:
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Center
        ) {

            //Campo de texto para o nome:
            TextField(
                value = nome,
                label = { Text("Digite o seu nome") }
            )
        }

        // Espaçamento vertical:
        Spacer(modifier = Modifier.height(15.dp))

        //3ª linha:
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Center
        ) {

            //Campo de texto para o telefone:
            TextField(
                value = telefone,
                label = { Text("Informe seu telefone") }
            )
        }

        // Espaçamento vertical:
        Spacer(modifier = Modifier.height(15.dp))

        //4ª linha:
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Center
        ) {

            //Campo de texto para o endereço:
            TextField(
                value = "endereco",
                label = { Text("Digite o seu endereço") },
            )
        }

        // Espaçamento vertical:
        Spacer(modifier = Modifier.height(15.dp))

        //5ª linha:
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Center
        ) {

            //Campo de texto para o CEP:
            TextField(
                value = "cep",
                label = { Text(text = "Digite o seu CEP") },
            )
        }

        // Espaçamento vertical:
        Spacer(modifier = Modifier.height(15.dp))

        //6ª linha:
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Center
        ) {

            //Campo de texto para o bairro:
            TextField(
                value = "bairro",
                label = { Text(text = "Informe qual é o seu bairro") },
            )
        }

        // Espaçamento vertical:
        Spacer(modifier = Modifier.height(15.dp))

        //7ª linha:
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Center
        ) {

            //Botão de cadastro:
            Button(
                onClick = {
                    val formValues = Form( // Create a Form object with entered data
                        nome.value,
                        telefone.value,
                        endereco.value,
                        cep.value,
                        bairro.value
                    )

                    onFormSubmit( // Call the provided function to handle submission
                        formValues.nome,
                        formValues.telefone,
                        formValues.endereco,
                        formValues.cep,
                        formValues.bairro
                    )

                    Toast.makeText(this@MainActivity, "Cadastrado com sucesso!", Toast.LENGTH_SHORT)
                        .show()
                    finish()

                }) {
                Text(text = "Cadastrar")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Atividade10Theme {
            Formulario()
        }
    }