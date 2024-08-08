package com.chronelab.basic.model

import java.io.Serializable

data class User(val id: Int = 0, var userName: String, var password: String): Serializable {

    fun validate(): Pair<Boolean, String> {
        var message = ""
        var status = true
        if (userName != "user") {
            status = false
            message = "Invalid user name."
        } else if (password != "password") {
            status = false
            message = "Invalid password."
        }
        return Pair(status, message)
    }
}