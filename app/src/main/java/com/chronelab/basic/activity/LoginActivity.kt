package com.chronelab.basic.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.chronelab.basic.model.User
import com.chronelab.basic.ui.theme.AndroidBasicTheme
import com.chronelab.basic.ui.view.ViewLogin

class LoginActivity : ComponentActivity() {
    companion object {
        private val  TAG = LoginActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "executing onCreate")
        enableEdgeToEdge()
        setContent {
            AndroidBasicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ViewLogin(validateUser = {user ->
                        btnLoginAction(user)
                    }
                    )
                }
            }
        }
    }

    private fun btnLoginAction(user: User): Boolean {
        val isValid = user.validate()
        if (isValid) {
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("key_user", user)
            }
            startActivity(intent)
        } else {
            Log.i(TAG, "You are not authorized!")
        }
        return isValid
    }
}
