package com.xnical.combigo.domain.util

import com.xnical.combigo.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

// CONVIERTE UNA RESPUESTA DE UNA SOLICITUD HTTP EN UN OBJETO RESOURCE QUE ENCAPSULA EL RESULTADO

object ResponseToRequest {
    // @param result La respuesta de la solicitud HTTP en forma de Response<T>.
    // @return Un objeto Resource que representa el resultado de la solicitud. Puede ser Resource.Success en caso de éxito,
    // o Resource.Failure en caso de error.

    fun <T> send(result: Response<T>): Resource<T> {
        return try {
            if (result.isSuccessful) { // 201
                Resource.Success(result.body()!!)
            }
            else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconcido")
            }
        }
        catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconido en la peticion Http")
        }
        catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure("Verifica tu conexion a internet")
        }
        catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconido")
        }
    }

}