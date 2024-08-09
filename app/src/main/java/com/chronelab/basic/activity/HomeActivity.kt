package com.chronelab.basic.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.chronelab.basic.model.Category
import com.chronelab.basic.model.CategoryHandler
import com.chronelab.basic.model.User
import com.chronelab.basic.ui.theme.AndroidBasicTheme
import com.chronelab.basic.ui.view.ViewHome

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
            AndroidBasicTheme {
                var categories by remember { mutableStateOf(CategoryHandler.catgories.toMutableStateList()) }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ViewHome(categories = categories, leftBtnAction = {
                        btnAddAction(categories)
                    }, rightBtnAction = {
                        btnLogoutAction()
                    })
                }
            }
        }
    }

    private fun btnAddAction(categories: MutableList<Category>) {
        categories.add(Category(3, "Grains"))
        CategoryHandler.addCategory(Category(3, "Grains"))
    }

    private fun btnLogoutAction() {
        finish()
    }
}