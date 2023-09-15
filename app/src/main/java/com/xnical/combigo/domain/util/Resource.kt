package com.xnical.combigo.domain.util

//Permite trabajar con diferentes
//<out T> : indica que el tipo T es un tipo de retorno
// T : El tipo de datos almacenados en el estado
sealed class Resource<out T> {
    object Loading: Resource<Nothing>()
    data class Success<out T>(val data: T): Resource<T>()
    data class Failure<out T>(val message: String): Resource<T>()
}
