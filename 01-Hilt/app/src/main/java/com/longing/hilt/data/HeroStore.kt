package com.longing.hilt.data

class HeroStore {

    private val heros = mapOf(
        "Samira" to Hero("Samira", 6300),
        "Garen" to Hero("Garen", 3150),
        "Master Yi" to Hero("Master Yi", 450),
        "Vayne" to Hero("Vayne", 4800),
        "Yasuo" to Hero("Yasuo", 6300),

        )

    fun provideHero(name: String): Hero = heros.getOrElse(name) { Hero("Teemo", 1350) }

    fun getHeros(): List<Hero> = heros.values.toList()
}