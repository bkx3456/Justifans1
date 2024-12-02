package com.example.justifans

import Recommendation
import com.example.justifans.R

object DummyData {

    fun getRecommendations(): List<Recommendation> {
        return listOf(
            Recommendation("Lightstick Ver.2", "Rp500.000", R.drawable.lightstick),
            Recommendation("Album Limited Edition", "Rp700.000", R.drawable.album),
            Recommendation("Poster Set", "Rp100.000", R.drawable.poster),
            Recommendation("Photocard Pack", "Rp50.000", R.drawable.photocard)
        )
    }
}
