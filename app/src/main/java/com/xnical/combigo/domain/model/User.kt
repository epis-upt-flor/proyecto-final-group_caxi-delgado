package com.xnical.combigo.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class User(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("password") val password: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("notification_token") val notificationToken: String? = null,
    @SerializedName("roles") val roles: ArrayList<Rol>? = null,
) : Serializable {
    // Toma la informacion del data class y devuelve un objet de tipo JSON
    fun toJson(): String = Gson().toJson(this)

    //function static
    companion object {
        //Convierte una cadena JSON en un object de la class User
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}