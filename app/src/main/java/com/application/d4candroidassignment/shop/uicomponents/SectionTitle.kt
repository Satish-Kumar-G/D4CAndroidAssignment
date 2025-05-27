package com.application.d4candroidassignment.shop.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.d4candroidassignment.ui.theme.centuryOldStyle


@Composable
fun SectionTitle(title : String, viewMoreText : String){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 12.dp)
    ){
        Text(
            title,
            style = TextStyle(
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = centuryOldStyle
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            viewMoreText,
            style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.Underline,
            )
        )
    }
}