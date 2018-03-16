package com.retroftiwithkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.retroftiwithkotlin.retrofit.ApiFactory
import com.retroftiwithkotlin.retrofit.StateArray
import com.retroftiwithkotlin.retrofit.StateResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var client: ApiFactory
    lateinit var recycler_view: RecyclerView
    var dataList: MutableList<StateArray> = ArrayList()
    var countryList: MutableList<CountryModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData() // Load data to array List

        recycler_view = findViewById(R.id.recycler_view) as RecyclerView
        //Declare  vertical(List) RecyclerView
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    private fun loadData() {

        client = ApiFactory //Declare ApiClient

        client.create().getStateList(1)
                .enqueue(object : Callback<StateResponse> {
                    override fun onResponse(call: Call<StateResponse>?, response: Response<StateResponse>?) {

                        if (response != null) {
                            if (response.isSuccessful) {
                                try {
                                    var success: Boolean = response.body().isSuccess
                                    var message: String? = response.body().message

                                    dataList = response.body().stateArrays!!
                                    var ICount = dataList.size

                                    for (i in 0 until ICount) {
                                        var name: String? = response.body().stateArrays!![i].stateName
                                        var id: Int? = response.body().stateArrays!![i].stateID
                                        var countryModel = CountryModel(name!!, id!!)

                                        countryList.add(countryModel)
                                    }
                                    //adapter set to recyclerView
                                    recycler_view.adapter = CountryAdapter(this@MainActivity, countryList)
                                } catch (e: Exception) {
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<StateResponse>?, t: Throwable?) {
                    }
                })
    }
}

