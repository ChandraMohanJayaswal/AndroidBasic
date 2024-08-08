package com.chronelab.basic.ui.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chronelab.basic.R
import com.chronelab.basic.model.User
import com.chronelab.basic.ui.theme.AndroidBasicTheme
import com.chronelab.basic.ui.view.header.HeaderLogin
import com.chronelab.basic.ui.view.util.ViewAlert

@Composable
fun ViewLogin(validateUser: ((user: User)-> Boolean)) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isValidUser by remember { mutableStateOf(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
    ) {
        HeaderLogin(title = stringResource(id = R.string.txt_login))
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
                    .imePadding()
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text(stringResource(id = R.string.txt_username)) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(stringResource(id = R.string.txt_password)) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        val user = User(id = 0, userName = username, password = password)
                        Log.i("LoginScreen", "Login button pressed!")
                        isValidUser = validateUser(user)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !(username == "" || password == "")
                ) {
                    Text(text = stringResource(id = R.string.txt_login))
                }

                if (!isValidUser) {
                    ViewAlert(
                        message = "Please make sure username and password is correct!",
                        dismissButtonText = "OK",
                        dismissButtonAction = {
                            isValidUser = !isValidUser
                        }
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ViewLoginPreview() {
    AndroidBasicTheme {
        ViewLogin(validateUser = { user ->
            true
        })
    }
}