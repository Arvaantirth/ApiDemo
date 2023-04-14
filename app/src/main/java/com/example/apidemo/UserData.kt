package com.example.apidemo


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

class UserData : ArrayList<UserData.UserDataItem>() {
    @Keep
    data class UserDataItem(
        @SerializedName("albumId")
        val albumId: Int?, // 1
        @SerializedName("id")
        val id: Int?, // 1
        @SerializedName("thumbnailUrl")
        val thumbnailUrl: String?, // https://via.placeholder.com/150/92c952
        @SerializedName("title")
        val title: String?, // accusamus beatae ad facilis cum similique qui sunt
        @SerializedName("url")
        val url: String? // https://via.placeholder.com/600/92c952
    )
}