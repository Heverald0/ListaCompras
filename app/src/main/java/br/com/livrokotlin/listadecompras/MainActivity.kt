package br.com.livrokotlin.listadecompras

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view_produtos)
        val btnInserir = findViewById<Button>(R.id.btn_inserir)
        val txtProduto = findViewById<EditText>(R.id.txt_produto)

        val produtosAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            mutableListOf()
        )

        listView.adapter = produtosAdapter

        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString().trim()
            if (produto.isNotEmpty()) {
                produtosAdapter.add(produto)
                txtProduto.text.clear()
            }else{
                txtProduto.error = "Preencha um valor"
            }
        }
        listView.setOnItemLongClickListener{
            adapterview: AdapterView<*>, view: View, position: Int, id: Long ->

            val item = produtosAdapter.getItem(position)

            produtosAdapter.remove(item)

            true
        }
    }
}
