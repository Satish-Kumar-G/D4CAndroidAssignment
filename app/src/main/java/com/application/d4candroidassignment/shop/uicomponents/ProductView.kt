package com.application.d4candroidassignment.shop.uicomponents

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.application.d4candroidassignment.R
import com.application.d4candroidassignment.shop.models.Product
import com.application.d4candroidassignment.ui.theme.Purple80
import com.application.d4candroidassignment.ui.theme.tangerine
import com.application.d4candroidassignment.ui.theme.textGreen


@SuppressLint("ResourceType")
@Composable
fun ProductView(product: Product) {

    val context = LocalContext.current
    val displayMetrics = context.resources.displayMetrics

    val widthPx = displayMetrics.widthPixels
    val density = displayMetrics.density

    val widthDp = widthPx / density

    Box(
        modifier = Modifier
            .height(height = 530.dp)
            .fillMaxWidth()
            .padding(4.dp)

    ) {
        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 8.dp),
            painter = painterResource(R.drawable.product_bg_card),
            contentDescription = "Product Background",
            contentScale = ContentScale.FillBounds
        )

        // Favourite button
        Card(
            modifier = Modifier
                .size(48.dp)
                .offset(6.dp, 6.dp),
            shape = RoundedCornerShape(50.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            ) {
                Image(
                    modifier = Modifier
                        .size(36.dp)
                        .offset(6.dp, 6.dp),
                    painter = painterResource(
                        if (product.isFavourite ) R.drawable.favoutite_selected else
                        R.drawable.favorite_unselected),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "Product Details",
                    colorFilter = ColorFilter.tint(color = Purple80)
                )
            }

        }
        

        //BestSeller
        if (product.isBestSeller) {
            Card(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset((-24).dp, 18.dp),
                colors = CardDefaults.cardColors(Color.Black),
                shape = RoundedCornerShape(25.dp),
            ) {
                Text(
                    "Best seller",
                    modifier = Modifier.padding(vertical = 6.dp, horizontal = 12.dp),
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = textGreen,
                        fontWeight = FontWeight.SemiBold,
                    )
                )
            }
        }
        //
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            ProductDetails(widthDp.dp,product)
        }
        //Product Image
        val imageUri = remember {
            // Build a URI for the raw resource
            Uri.parse("android.resource://${context.packageName}/${product.productImage}")
        }
        AsyncImage(
            model = imageUri,
            contentDescription = "",
            modifier = Modifier.size(300.dp)
                .align(Alignment.TopCenter)
                .padding(top = 60.dp),
                //.offset(150.dp,200.dp),
            contentScale = ContentScale.Crop,

            )

    }
}


@Composable
fun ProductDetails(width: Dp = 411.dp,  product: Product) {


    Box(
        modifier = Modifier.width(width)
    ) {

        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            painter = painterResource(R.drawable.product_title_card),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Product Details"
        )

        // Cart button
        Box(
            modifier = Modifier
                .padding(end = 12.dp, bottom = 12.dp)
                .align(Alignment.BottomEnd)
        ) {
            Card(
                modifier = Modifier
                    .size(52.dp),
                shape = RoundedCornerShape(50.dp),
                border = BorderStroke(1.dp, color = textGreen)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black)
                ) {
                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .offset(12.dp, 12.dp),
                        painter = painterResource(R.drawable.grocery_store),
                        contentScale = ContentScale.FillWidth,
                        contentDescription = "Product Details",
                        colorFilter = ColorFilter.tint(color = textGreen
                        )

                    )
                }

            }
        }

        Column(
            modifier = Modifier.padding(top = 12.dp, start = 24.dp, end = 32.dp)
        ) {

            // Product Name and status
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.productName,
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = textGreen,
                        fontFamily = tangerine,
                    ),

                    )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(product.stockStatus.getStatusColor())
                        .border(0.dp, Color.White, CircleShape)
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    product.stockStatus.getStatusTitle(),
                    style = TextStyle(
                        color = product.stockStatus.getStatusColor(),
                        fontSize = 12.sp
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = product.productDescription,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Normal
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = product.productUsedFor[0],
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(0.dp, Color.White, CircleShape)
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = product.productUsedFor[1],
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "${product.currency.currencyCode} ${product.price.newPrice}",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Purple80,
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "${product.currency.currencyCode} ${product.price.oldPrice}",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal,
                        textDecoration = TextDecoration.LineThrough
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 4.dp)
            ){
                StaticRatingBar(rating = product.rating)
                Spacer(modifier = Modifier.width(8.dp))

                Text("238 reviews",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.White,
                        textDecoration = TextDecoration.Underline
                    ))
            }


        }


    }
}

@Composable
fun StaticRatingBar(rating: Int, maxRating: Int = 5) {
    Row {
        for (i in 1..maxRating) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = if (i <= rating) Color(0xFFFFC107) else Color.Gray,
                modifier = Modifier.size(12.dp)
            )
        }
    }
}