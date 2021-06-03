package com.saket.kotlinobjectexpression.singleton

/**
 * Object keyword in class declaration is used for object declaration. It is used
 * to create singleton instance of class in kotlin.
 *
 * It is not possible to inherit from Singleton class in Kotlin. But object class can
 * inherit from other super class.
 */

object KotlinSingleton {
    val version = "1.5.10"

    var supportsJava = true

    fun getLinesOfCodeInKotlin(linesInJava : Int): Int {
        return linesInJava / 2
    }
}