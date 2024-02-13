package com.example.weatherapp.model

class QuoteProvider {

    // companion is like an static
    companion object {
        fun random():QuoteModel {
            val position = (0..2).random()
            return _list[position]
        }
        private val _list = listOf<QuoteModel>(

            QuoteModel("My First quote", "by Francisco"),
            QuoteModel("My Second quote", "by Francisco Martin"),
            QuoteModel("My Third quote", "by Martin"),
            QuoteModel("Strangers,strangers into brothers", "Blink 182"),
            QuoteModel("Arigato", "Luffy"),

            )
    }
}