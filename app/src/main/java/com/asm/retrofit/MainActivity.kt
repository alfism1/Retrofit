package com.asm.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.asm.retrofit.controller.QuotesApi
import com.asm.retrofit.helper.RetrofitHelper
import com.asm.retrofit.model.QuoteList
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var rvQuoteList: RecyclerView
//    lateinit var recyclerViewAdapter: RecyclerAdapter
    lateinit var quoteList: QuoteList

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvQuoteList = findViewById(R.id.rvQuoteList)



        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

        GlobalScope.launch {
            val result = quotesApi.getQuotes()

            Log.d("MainActivity", result.body().toString())
//            recyclerViewAdapter = RecyclerAdapter(quoteList)
//            rvQuoteList.adapter = recyclerViewAdapter
        }
    }
}
