package com.gayatri.newsapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.gayatri.newsapp.api.Article
import com.gayatri.newsapp.api.NewsResponse
import com.gayatri.newsapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: NewsAdapter
    private var mRequestQueue: RequestQueue? = null
    private var mStringRequest: StringRequest? = null
    private lateinit var news : NewsResponse
    private val url = "https://candidate-test-data-moengage.s3.amazonaws.com/Android/news-api-feed/staticResponse.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newslist.layoutManager = LinearLayoutManager(this)
        myAdapter = NewsAdapter(ArrayList())
        binding.newslist.adapter = myAdapter

        getData()
    }

    private fun getData() {
        // RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this)

        // String Request initialized
        mStringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                Toast.makeText(applicationContext, "Response :$response", Toast.LENGTH_LONG)
                    .show() //display the response on screen

                news = response

            }
        ) { error -> Log.i(TAG, "Error :$error") }
        mRequestQueue!!.add(mStringRequest)
    }

}