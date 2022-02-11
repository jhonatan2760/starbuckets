package br.com.jhonatansouza.starbuckets.converter

abstract class Mapper<T, E> {

    abstract fun toEntity(dto: T) : E

}