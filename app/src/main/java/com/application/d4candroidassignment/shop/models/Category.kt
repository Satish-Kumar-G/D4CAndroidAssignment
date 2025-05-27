package com.application.d4candroidassignment.shop.models

import com.application.d4candroidassignment.R

data class Category(
    val categoryId : String,
    val categoryName : String,
    val categoryImage : Int,
    
)

// this will share us the required sample data to the UI
object CategoryList{
    fun getCategories(): List<Category>{
        val categories = mutableListOf<Category>()
        categories.add(Category("1","Cleaners", R.raw.cleanser))
        categories.add(Category("2","Toner", R.raw.toner))
        categories.add(Category("3","Serums", R.raw.serum))
        categories.add(Category("4","Moisturiser", R.raw.moisturizer))
        categories.add(Category("5","Sunscreens", R.raw.sunscreen))
        categories.add(Category("6","Perfumes", R.raw.perfume))
        categories.add(Category("7","Hair gels", R.raw.hair_gel))

        return  categories
    }
}

