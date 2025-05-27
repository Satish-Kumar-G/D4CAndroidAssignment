package com.application.d4candroidassignment.shop.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.application.d4candroidassignment.shop.models.CategoryList
import com.application.d4candroidassignment.shop.models.ProductList
import com.application.d4candroidassignment.shop.uicomponents.CategoryView
import com.application.d4candroidassignment.shop.uicomponents.CustomToolbar
import com.application.d4candroidassignment.shop.uicomponents.ProductView
import com.application.d4candroidassignment.shop.uicomponents.SectionTitle
import com.application.d4candroidassignment.shop.uicomponents.ShopPageHeaderView
import com.application.d4candroidassignment.ui.theme.D4CAndroidAssignmentTheme
import com.application.d4candroidassignment.ui.theme.lightGray


class ShopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            D4CAndroidAssignmentTheme(darkTheme = true ) {
                Scaffold(
                    containerColor = lightGray,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = lightGray),

                ) { innerPadding ->
                    val pad = Modifier.padding(innerPadding)
                    CollapsingToolbarScreen()
                }
            }
        }
    }

}



@Composable
fun CollapsingToolbarScreen() {
    val products = ProductList.getProductList()
    val categories = CategoryList.getCategories()
    val toolbarHeight = 100.dp
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.toPx() }

    val scrollState = rememberLazyListState()
    val offset = remember {
        derivedStateOf {
            // Clamp the offset to [0, toolbarHeight]
            minOf(scrollState.firstVisibleItemScrollOffset.toFloat(), toolbarHeightPx)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = toolbarHeight),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Top header view where offers are displayed
            item {
                ShopPageHeaderView()
            }
            // This is the Categories section
            item {
                SectionTitle("Categories", "See all")
            }
            item {
                LazyRow {
                    items(categories){category ->
                        CategoryView(category)
                    }
                }
            }
            // This is Products section
            item {
                SectionTitle("New Products", "See all")
            }
            items(products){product ->
                ProductView(product)
            }

        }

        // Custom Collapsing Toolbar
        Box(
            modifier = Modifier
                .height(toolbarHeight)
                .fillMaxWidth()
                .graphicsLayer {
                    translationY = -offset.value // Move it up as you scroll
                }
                .background(Color.Transparent)
                .padding(4.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            CustomToolbar()
        }
    }
}


