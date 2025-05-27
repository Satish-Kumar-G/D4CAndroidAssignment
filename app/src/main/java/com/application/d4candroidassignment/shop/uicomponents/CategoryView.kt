package com.application.d4candroidassignment.shop.uicomponents

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.application.d4candroidassignment.shop.models.Category


//This method will create a view for the category items

@Composable
fun CategoryView(category: Category, height: Dp = 80.dp, width: Dp = 80.dp) {
    val mCategory = remember { category }
    val context = LocalContext.current
    val imageUri = remember {
        // Build a URI for the raw resource
        Uri.parse("android.resource://${context.packageName}/${category.categoryImage}")
    }
    Box(
        modifier = Modifier.size(
            width = width,
            height = height,
        )
    ) {
        Card(
            shape = RoundedCornerShape(46.dp),
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.TopCenter)
                .background(color = Color.Transparent)

        ) {
            AsyncImage(
                model = imageUri,
                modifier = Modifier.size(60.dp)
                    .background(color = Color.Black),
                contentDescription = "This view holds the category image",
                contentScale = ContentScale.Crop
            )

        }
        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 2.dp, top = 4.dp)
            ,
            text = mCategory.categoryName,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,

            )
            )

    }
}