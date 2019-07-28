package com.douglas.android.domain

interface Mapper<in FROM, out TO> {

    fun map(from: FROM): TO
}