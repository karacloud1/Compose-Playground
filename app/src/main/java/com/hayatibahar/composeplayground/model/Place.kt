package com.hayatibahar.composeplayground.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.hayatibahar.composeplayground.R
import kotlin.random.Random

@Immutable
data class Place(
    val id: Long,
    val description: String,
    @DrawableRes val imgRes: Int,
    val rating: Double = Random.nextDouble(0.0, 10.0),
    val price: Int = Random.nextInt(500)
)

val places = listOf(
    Place(1, "Place1", R.drawable.howl_s_moving_castle_1),
    Place(2, "Place2", R.drawable.howl_s_moving_castle_2),
    Place(3, "Place3", R.drawable.howl_s_moving_castle_3),
    Place(4, "Place4", R.drawable.howl_s_moving_castle_4),
    Place(5, "Place5", R.drawable.howl_s_moving_castle_5),
)