package com.example.livedatademo.ui.base

interface BaseModelToItemViewlMapper<in M, out I> {

    fun map(model: M): I

    fun map(models: List<M>): List<I> = models.map { this.map(it) }

}