package com.chronelab.aug5.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chronelab.aug5.model.Category
import com.chronelab.aug5.model.CategoryHandler
import com.chronelab.aug5.ui.theme.Aug5Theme


@Composable
fun ViewHome(categories: List<Category>,
    leftBtnAction: ( () -> Unit),
    rightBtnAction: ( () -> Unit)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
    ) {
        HeaderHome(
            title = "Home",
            leftBtnAction = leftBtnAction,
            rightBtnAction = rightBtnAction)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ){
                Categories(categories = categories)
            }
        }
    }
}

@Composable
fun Categories(categories: List<Category>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(categories) {category ->
            Category(category)
        }
    }
}

@Composable
fun Category(category: Category) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = category.name, style = MaterialTheme.typography.titleMedium, fontSize = 20.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ViewHomePreview() {
    Aug5Theme {
        ViewHome(categories = CategoryHandler.catgories, leftBtnAction = {}, rightBtnAction = {})
    }
}