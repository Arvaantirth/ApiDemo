package com.example.apidemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_main)
        getUsersData()
    }

    private fun getUsersData() {

        ApiClient.retrofit().create(ApiInterface::class.java).getUsers()
            .enqueue(object : Callback<MutableList<UserData.UserDataItem>> {
                override fun onFailure(
                    call: Call<MutableList<UserData.UserDataItem>>,
                    t: Throwable
                ) {
                    t.localizedMessage?.let { Log.e("error", it) }
                }

                override fun onResponse(
                    call: Call<MutableList<UserData.UserDataItem>>,
                    response: Response<MutableList<UserData.UserDataItem>>
                ) {

                    Log.e("TAG", "onResponse: $response")
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = response.body()?.let {
                        UsersAdapter(this@MainActivity, it)
                    }
                }

            })
    }
}