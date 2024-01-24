package com.mahammadjafarzade.common.flowstate

sealed class Resource<T>(var data : T? = null,
                          var message : String? = null) {

    class Success<T>(data: T) : Resource<T>(data = data)
    class Error(message: String?) : Resource<String>(message = message)
    class Loading<T>() : Resource<T>()
}