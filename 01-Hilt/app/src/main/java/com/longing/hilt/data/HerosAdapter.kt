package com.longing.hilt.data

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class HerosAdapter @Inject constructor(
    private val store: HeroStore
) {

    fun getHero(name: String) = store.provideHero(name)
    fun listHero(): List<Hero> = store.getHeros()
}