package com.example.livedatademo.domain.base

interface BaseEntityToModelMapper<in E, out M> {

    fun map(entity: E): M

    fun map(entities: List<E>): List<M> = entities.map { this.map(it) }

}