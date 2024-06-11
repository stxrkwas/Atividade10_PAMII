package com.example.atividade10.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DBHelper(context:Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION){

        override fun onCreate(db: SQLiteDatabase) {

            // Criando uma tabela
            val query = ("CREATE TABLE " + TABLE_NAME + " (" +
                    ID_COL + "INTEGER PRIMARY KEY, " +
                    NOME_COL + " TEXT," +
                    TEL_COL + " TEXT," +
                    END_COL + " TEXT," +
                    BAR_COL + " TEXT," +
                    CEP_COL + " TEXT," + ")")

            // Chamando método sqlite para a execução da tabela
            db.execSQL(query)

        }

        override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int){

            //Este método checa se a tabela já existe
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
            onCreate(db)

        }

        fun addPessoa(nome: String, tel: String, end: String, cep: String, bar: String){

            //Criando uma variável com um método para conter os valores
            val values = ContentValues()

            // - Pesquisar depois -
            values.put(NOME_COL, nome)
            values.put(TEL_COL, tel)
            values.put(END_COL, end)
            values.put(CEP_COL, cep)
            values.put(BAR_COL, bar)

            // Criando uma variável que pode ser reescrita quando quiser inserir valores no banco de dados
            val db = this.writableDatabase

            // Garante que todos od valores sejam registrados no banco
            db.insert(TABLE_NAME, null, values)

            // Fechando o banco de dados
            db.close()
        }

        companion object{

            // Variável para nomear o banco
            private val DATABASE_NAME = "Form"

            // Versão do banco de dados
            private val DATABASE_VERSION = 1

            // Nome da tabela
            val TABLE_NAME = "CadastroUsuario"

            // Nomeando a coluna identificadora do usuário
            val ID_COL = "id"

            // Coluna do nome
            val NOME_COL = "nome"

            // Variável para a coluna telefone
            val TEL_COL = "telefone"

            // Variável para a coluna endereço
            val END_COL = "endereco"

            // Variável para a coluna cep
            val CEP_COL = "cep"

            // Variável para a coluna bairro
            val BAR_COL = "bairro"
        }

}