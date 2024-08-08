package com.chronelab.aug5.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.chronelab.aug5.model.Category
import com.chronelab.aug5.model.CategoryHandler
import com.chronelab.aug5.model.User
import com.chronelab.aug5.ui.theme.Aug5Theme
import com.chronelab.aug5.ui.view.ViewHome

class HomeActivity : ComponentActivity() {
    companion object {
        private val  TAG = HomeActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user: User? = intent.getSerializableExtra("key_user") as? User
        Log.i(TAG, "${CategoryHandler.catgories}")
        enableEdgeToEdge()
        setContent{
            Aug5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ViewHome(categories = CategoryHandler.catgories, leftBtnAction = {
                        btnAddAction()
                    }, rightBtnAction = {
                        btnLogoutAction()
                    })
                }
            }
        }
    }

    private fun btnAddAction() {
        CategoryHandler.addCategory(Category(3, "Grains"))
    }

    private fun btnLogoutAction() {
        finish()
    }
}