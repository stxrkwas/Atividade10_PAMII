package com.example.atividade10

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash.finish
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.atividade10.R
import com.example.atividade10.db.DBHelper
class RespostaActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_resposta)

        // 'findViewById' vincula um elemento a uma variável
        // 'EditText' permite que o usuário insira e edite um texto
        val edtNome: EditText = findViewById(R.id.edtNome)
        val edtTelefone: EditText = findViewById(R.id.edtTelefone)
        val edtEndereco: EditText = findViewById(R.id.edtEndereco)
        val edtCep: EditText = findViewById(R.id.edtCEP)
        val edtBairro: EditText = findViewById(R.id.edtBairro)

        // Botão para cadastrar os dados inseridos nos campos de texto
        val btnConfirmar: Button = findViewById(R.id.btnConfirmar)

        edtNome.setText(intent.getStringExtra("nome"))
        edtTelefone.setText(intent.getStringExtra("telefone"))
        edtEndereco.setText(intent.getStringExtra("endereco"))
        edtCep.setText(intent.getStringExtra("cep"))
        edtBairro.setText(intent.getStringExtra("bairro"))

        val db = DBHelper(this, null)

        btnConfirmar.setOnClickListener{
            db.addPessoa(edtNome.text.toString(), edtTelefone.text.toString(), edtEndereco.text.toString(), edtCep.text.toString(), edtBairro.text.toString())
            finish()
        }
    }

}