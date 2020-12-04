package com.example.desafiowebservices.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiowebservices.R
import com.example.desafiowebservices.adapter.MainAdapter
import com.example.desafiowebservices.service.repository
import com.example.desafiowebservices.ui.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainAdapter.OnItemClickListener {
    private val viewModel by viewModels<MainViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onItemClick(position: Int) {
        var itemClick = viewModel.listQhsFromApi.value?.data?.results?.get(position)
        val intent = Intent(this, DescricaoActivity::class.java)
        intent.putExtra("itemClick", itemClick)
        startActivity(intent)
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_hqs.setHasFixedSize(true)
        viewModel.listQhsFromApi.observe(this) {
            recyclerview_hqs.swapAdapter(MainAdapter(it, this), true)
            progressbar_loading.visibility = View.INVISIBLE
        }
        viewModel.getHqs()
    }
}