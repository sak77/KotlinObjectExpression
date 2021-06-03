package com.saket.kotlinobjectexpression

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.saket.kotlinobjectexpression.singleton.KotlinSingleton

/**
 * Sometimes you need to create an object of a slight modification of some class,
 * without explicitly declaring a new subclass for it.
 * Kotlin handles this case with object expressions and object declarations.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Object expressions create objects of anonymous classes, that is, classes that aren't explicitly declared with the 'class' declaration.
        Such classes are handy for one-time use.
        You can define them from scratch, inherit from existing classes, or implement interfaces.
        Instances of anonymous classes are also called anonymous objects because they are defined by an expression, not a name.
         */

        //Anonymous object
        val helloWorld = object {
            val hello = "Hello"
            val world = "World"

            override fun toString(): String {
                return "$hello $world"
            }
        }

        println("${myA.getA()}")

        val myKotlin = KotlinSingleton
        if (myKotlin.supportsJava) {
            println("My Kotlin version is ${myKotlin.version}")
            myKotlin.supportsJava = false
        }

        //Since its a singleton, any changes made above should apply here as well...
        val myKotlinAgain = KotlinSingleton
        println("Does Kotlin Support Java now? ${myKotlinAgain.supportsJava}")

    }

    //Inheriting anonymous object from supertypes
    open class A {
        open fun getA() = "This is A"
    }

    val myA = object : A() {
        override fun getA(): String {
            return "This is My A"
        }
    }

    //if super type has constructor
    open class B(x: Int) {
        open val b = x
    }

    interface C {
        fun getC()
    }

    val bc: B = object : B(2), C {
        override fun getC() {
            println("This is MY C")
        }
    }

    /*
    The code in object expressions can access variables from the enclosing scope.
     */
    fun countClicks(view: View) {
        var clickCount = 0
        view.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                clickCount += 1
            }
        })
    }

    //Members of the companion object can be called by using simply the class name as the qualifier:
    val student = Student.create()

    //The name of the companion object can be omitted, in which case the name Companion will be used:
    class Parent {
        companion object {
            fun create() : Parent = Parent()
        }
    }

    val parentCompanion = Parent.Companion
    val parent = parentCompanion.create()
}