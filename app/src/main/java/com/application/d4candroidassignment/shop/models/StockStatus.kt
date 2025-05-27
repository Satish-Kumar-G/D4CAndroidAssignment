package com.application.d4candroidassignment.shop.models

import androidx.compose.ui.graphics.Color
import com.application.d4candroidassignment.ui.theme.textGreen

// This Enum will tell us the status of the product availability and also share the color code and name
enum class StockStatus(private val title: String, val color: Color) {
    OUT_OF_STOCK("Out of stock",Color.Red),
    IN_STOCK("In stock", textGreen);

    fun getStatusColor(): Color {
        return color
    }
    fun getStatusTitle(): String {
        return  title
    }
}