package com.saket.kotlinobjectexpression

/**
 * This class is used to demonstrate companion Objects.
 *
 * Companion objects are somewhat similar to static fields in java.
 *
 * Which means they can be accessed without creating instance of the enclosing class.
 *
 * Only one companion object is allowed per class...
 *
 * Class members can access the private fields of a corresponding companion object.
 */
class Student {

    //lateinit modifier cannot be used on primitive types...
    lateinit var rollNo : String

    companion object Factory {
        fun create(): Student = Student()
    }
}