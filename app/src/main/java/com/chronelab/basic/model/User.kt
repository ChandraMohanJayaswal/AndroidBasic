package com.chronelab.basic.model

import java.io.Serializable

data class User(val id: Int = 0, var userName: String, var password: String): Serializable {

    fun validate(): Boolean {
        return  (userName == "user" && password == "password")
    }
}