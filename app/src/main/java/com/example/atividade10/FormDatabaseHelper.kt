package com.example.atividade10

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class FormDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{

        private const val DATABASE_NAME = "form.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "registros"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NOME = "nome"
        private const val COLUMN_TELEFONE = "telefone"
        private const val COLUMN_ENDERECO = "endereco"
        private const val COLUMN_CEP = "cep"
        private const val COLUMN_BAIRRO = "bairro"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NOME STRING, $COLUMN_TELEFONE STRING, " +
                "$COLUMN_ENDERECO STRING, $COLUMN_CEP STRING, $COLUMN_BAIRRO STRING)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun registerForm(form: Form){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOME, form.nome)
            put(COLUMN_TELEFONE, form.telefone)
            put(COLUMN_ENDERECO, form.endereco)
            put(COLUMN_CEP, form.cep)
            put(COLUMN_BAIRRO, form.bairro)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }
}