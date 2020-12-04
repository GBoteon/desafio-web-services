package com.example.desafiowebservices.activity

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.desafiowebservices.R
import com.example.desafiowebservices.`class`.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_descricao.*
import java.text.SimpleDateFormat
import java.util.*

class DescricaoActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descricao)

        imageview_retorna_main.setOnClickListener {
            finish()
        }
        imageview_poster.setOnClickListener {
            materialcardview_descricao_poster.visibility = View.VISIBLE
        }
        imageview_fecha_image.setOnClickListener {
            materialcardview_descricao_poster.visibility = View.INVISIBLE
        }

        var itemAtual = intent.getSerializableExtra("itemClick") as? Results
        var fundo = "${itemAtual?.thumbnail?.path}.${itemAtual?.thumbnail?.extension}"
        var descricao = itemAtual?.description
        if (descricao==null)
        {
            descricao="A API não obteve retorno  para essa descrição."
        }
        var titulo = itemAtual?.title
        var published = itemAtual?.dates?.get(0)?.date
        var price = itemAtual?.prices?.get(0)?.price
        var pages = itemAtual?.pageCount

        textview_titulo.text = titulo
        textview_decricao.text = descricao
        textview_pages.text = pages.toString()
        textview_price.text = "$ $price"
        val formatter: SimpleDateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        textview_published.text = formatter.format(published)
        Picasso.get().load(Uri.parse(fundo)).into(imageview_plano_fundo)
        Picasso.get().load(Uri.parse(fundo)).into(imageview_poster)
        Picasso.get().load(Uri.parse(fundo)).into(imageview_descricao_poster)
    }

}