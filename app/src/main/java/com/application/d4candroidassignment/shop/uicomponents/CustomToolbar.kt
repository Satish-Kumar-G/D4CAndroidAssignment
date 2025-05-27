package com.application.d4candroidassignment.shop.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.d4candroidassignment.R
import com.application.d4candroidassignment.ui.theme.centuryOldStyle
import com.application.d4candroidassignment.ui.theme.textGreen

@Preview
@Composable
fun CustomToolbar() {
    Box(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp)){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(R.drawable.back_arrow),
                    contentDescription = "Home Icon",
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Shop",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontFamily = centuryOldStyle
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                SearchItem(R.drawable.search)
                CartItems(5,R.drawable.favorite_unselected)
                CartItems(3, R.drawable.trolley)

            }
        }
    }
}

@Composable
fun CartItems(count: Int,resource: Int) {
    Box(
        modifier = Modifier.padding(end = 8.dp)
    ) {
        Image(
            modifier = Modifier.size(36.dp,36.dp),
            painter = painterResource(resource),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = Color.White)
        )
        Card (
            modifier = Modifier.offset(10.dp,12.dp)
                .align(Alignment.Center)
        ){
            Box(
                modifier = Modifier.background(color = textGreen).size(20.dp)
            ){
                Text("$count",
                    modifier = Modifier.align(Alignment.Center),
                    style = TextStyle(
                        color = Color.Black
                    )
                )
            }

        }
    }
}
@Composable
fun SearchItem(resource: Int){
    Box(modifier = Modifier.padding(end = 8.dp)){
        Image(
            modifier = Modifier.size(36.dp,36.dp),
            painter = painterResource(resource),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(color = Color.White)
        )
    }
}