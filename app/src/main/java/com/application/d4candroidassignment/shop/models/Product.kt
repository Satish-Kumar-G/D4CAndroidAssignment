package com.application.d4candroidassignment.shop.models

import com.application.d4candroidassignment.R

data class Product(
    val productName : String,
    val productDescription : String,
    val rating : Int,
    val currency : Currency,
    val stockStatus: StockStatus,
    val isBestSeller : Boolean,
    val isFavourite : Boolean = false,
    val productImage : Int,
    val productUsedFor : List<String>,
    val price: Price,
    val reviewsCount : Int

)

//This is the object created to provide the dummy data to the UI.
object ProductList{
    fun getProductList(): List<Product>{
        val products = mutableListOf<Product>()
        var product = Product(productName = "Clencera",
            productDescription = "Fresh clay and algae-powered cleanser",
            rating = 5,
            currency = Currency("1","INR", "Rs"),
            stockStatus = StockStatus.IN_STOCK,
            isBestSeller = true,
            isFavourite = true,
            productImage = R.raw.product_image,
            productUsedFor = listOf("Skin Tightness","Dry & Dehydrated Skin"),
            price = Price("650.00","599.00"),
            reviewsCount = 298
                )
        products.add(product)

        product = Product(productName = "Glow",
            productDescription = "Fresh clay and algae-powered cleanser",
            rating = 3,
            currency = Currency("1","INR", "Rs"),
            stockStatus = StockStatus.IN_STOCK,
            isBestSeller = false,
            isFavourite = false,
            productImage = R.raw.categorysample,
            productUsedFor = listOf("Skin Tightness","Dry & Dehydrated Skin"),
            price = Price("444.00","355.20"),
            reviewsCount = 249
        )
        products.add(product)
        product = Product(productName = "Nivea",
            productDescription = "Fresh clay and algae-powered cleanser",
            rating = 1,
            currency = Currency("1","INR", "Rs"),
            stockStatus = StockStatus.OUT_OF_STOCK,
            isBestSeller = false,
            isFavourite = false,
            productImage = R.raw.nivea,
            productUsedFor = listOf("Skin Tightness","Dry & Dehydrated Skin"),
            price = Price("444.00","355.20"),
            reviewsCount = 249
        )
        products.add(product)

        return  products
    }
}

