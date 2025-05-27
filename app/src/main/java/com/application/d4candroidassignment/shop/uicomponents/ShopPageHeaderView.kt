package com.application.d4candroidassignment.shop.uicomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.d4candroidassignment.R
import com.application.d4candroidassignment.ui.theme.textGreen
import java.util.Locale

@Preview
@Composable
fun ShopPageHeaderView(){
    val offerText = "Get 20% off"
    val offerDuration = "12-16 October"

    Box(
        modifier = Modifier.fillMaxWidth(1f

        )
    ){
        Image(
            painter = painterResource(R.drawable.banner_card),
            modifier = Modifier.align(Alignment.TopCenter),
            contentDescription = "This is the banner image",
            contentScale = ContentScale.Crop
        )

        Column (
            modifier = Modifier.padding(top = 24.dp, start = 72.dp)
        ){
            Text(
                text = offerText.uppercase(Locale.ENGLISH),
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,

                    ),

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(offerText,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            Card {
                Box(modifier = Modifier.background(color = textGreen)){
                    Text(offerDuration,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        ))
                }
            }

        }
        Image(
            modifier = Modifier.size(72.dp)
                .offset(x=  (-60).dp)
                .align(Alignment.CenterEnd),
            painter = painterResource(R.drawable.mountains),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = Color.White)
        )

        Row (
            modifier = Modifier.
            align(Alignment.BottomStart)
                .padding(start = 80.dp, bottom = 8.dp)

        ){
            Card {
                Box(
                    modifier = Modifier.size(
                        width = 24.dp,
                        height = 8.dp
                    ) .background(color = textGreen)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                border = BorderStroke( width = 0.dp, color = Color.Black)
            ) {
                Box(
                    modifier = Modifier.size(
                        width = 24.dp,
                        height = 8.dp
                    ).background(color = Color.Black)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card {
                Box(
                    modifier = Modifier.size(
                        width = 24.dp,
                        height = 8.dp
                    ).background(color = Color.Black)
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))



    }

}

