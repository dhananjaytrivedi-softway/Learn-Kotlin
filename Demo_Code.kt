package CrashCourse

import java.lang.IllegalArgumentException
import java.util.*

fun main(args: Array<String>) {

    println(5/0)

    println("""

        hello \n world

        """)

    var bigInt: Int = Int.MAX_VALUE
    val smallInt = Int.MIN_VALUE

    // This is the way you print
    println("Biggest Int : " + bigInt)

    // This is String Interpolation
    println("Smallest Int : $smallInt")

    // Supporting Data Types :
    // Long Double Floats Boolean Short(16 Byte) Byte(8 Byte)
    // Longs are Huge by the way
    // There is a loss of precession while working with floating point numbers which you should verify on your own system
    // Adding the 16th digit is losing the precession


    // Double
    var doubleNumber1: Double = 1.1111111111111111
    var doubleNumber2: Double = 1.1111111111111111
    var sum = doubleNumber1 + doubleNumber2
    println(sum)

    // Boolean
    var booleanVariable = true
    var secondBoolean: Boolean = false
    if (true is Boolean) {
        println("Yes It is boolean!")
    }

    // Char
    var letterGrade: Char = 'A'
    var letterGrade2 = 'B'

    // Casting
    var sumToIntVariable = sum.toInt()
    println(sumToIntVariable)

    val myName = "DevDeejay"
    var fName = "Dhananjay"
    var lName = "Trivedi"
    var fullName1 = fName + " " + lName
    var fullName = "$fName $lName"

    println()

    // String interpolation with Kotlin expression is done using { }
    println("String Length :  ${fullName.length}")
    println("is fullName and fullName1 same ? ${fullName.equals(fullName1)}")

    // String operations
    var str1 = "A random string"
    var str2 = "a random string"

    println(str1.subSequence(2, 8))
    println(str2.contains("random"))

    println()

    // Creating Arrays
    var myArray = arrayOf(1, 2, 3, 4.2323123, "DJ")
    println(myArray[2])
    myArray[1] = 3.14
    println("Array Length   ${myArray.size}")
    println("Array contain Dj? ${myArray.contains("DJ")}")

    var sqArray = Array(5, { x -> x * x })
    println(sqArray[2])

    // Ranges are really cool
    val oneToTen = 1..10
    val alpha = "A".."Z"
    println("R in alpha  : ${"R" in alpha} ")

    val tenTo1 = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)
    val rng3 = oneToTen.step(3)

    for (x in rng3) println("rng3 : $x")

    for (x in tenTo1.reversed()) println("Reverse : $x")


    println()


    // Operators

    val age = 8
    if (age < 5) {
        println("Go to preschool ")
    } else if (age == 5) {
        println("Go to School")
    } else {
        val grade = age - 5
        println("Go to grade $grade")
    }


    println()

    // Switch Case

    when (age) {
        0, 1, 2, 3, 4 -> println("Go to PreSchool")
        5 -> println("Go to Kindergarten")
        in 6..17 -> {
            println("Go to grade $age")
        }
        else -> println("Go To College")
    }


    println()

    // Looping :

    for (x in 1..10) {
        println("Loop : $x")
    }
    // You can use Java libraries in Kotlin btw
    val random = Random()  // Notice no 'new' keyword
    val magicNumber = random.nextInt(50) + 1 // Notice we are using the java nextInt() method

    for (x in 1..20) {
        if (x % 2 == 0) {
            continue
        }
        println("Odd :  $x")
        if (x == 15) break
    }

    var arr3: Array<Int> = arrayOf(3, 6, 9)

    for (i in arr3.indices) {
        println("Multi of 3 :  ${arr3[i]}")
    }

    for ((index, value) in arr3.withIndex()) {
        println("Index : $index Value : $value")
    }


    println()

    // Functions

    fun add(num1: Int, num2: Int): Int = num1 + num2
    println("5 + 4  = ${add(5, 4)}")

    fun subtract(num1: Int = 1, num2: Int = 1) = num1 - num2
    print("5 - 4 =${subtract(5, 4)}")

    println("4 - 5 = ${subtract(num2 = 5, num1 = 4)}")

    // If a function doesn't return anything i.e. 'void' of Java is called 'Unit' here in Kotlin
    fun sayHello(name: String): Unit = println(name)

    sayHello("Somu")

    // Function that returns two values! <3 Something I wanted in Java

    fun nextTwo(num: Int): Pair<Int, Int> {
        return Pair(num + 1, num + 2)
    }

    val (two, three) = nextTwo(1)
    println("1,$two,$three")


    fun getSum(vararg nums: Int): Int {
        var sum = 0
        nums.forEach { n -> sum += n }
        return sum
    }

    println("${getSum(1, 2, 3, 4, 5)}")

    val multiply = { num1: Int, num2: Int -> num1 * num2 }

    println("5 * 3 = ${multiply(5, 3)}")

    // Recursion in Kotlin, We create a factorial method
    // See keywords, tailrec before the fun, A function which plans to call itself must be defined as tail-rec

    fun fact(x: Int): Int {
        tailrec fun factTail(y: Int, z: Int): Int {
            if (y == 0) return z
            else
                return factTail(y - 1, y * z)
        }
        return factTail(x, 1)
    }

    println("5! = ${fact(5)}")

    println()

    // Creating a function that returns a created function
    fun makeMathFunction(num1: Int): (Int) -> Int = { num2 -> num1 * num2 }

    // Using above function
    val multiple3 = makeMathFunction(3)

    // Passing a function as a parameter
    fun mathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int) {
        for (num in numList) {
            println("MathOnList ${myFunc(num)}")
        }
    }

    // This is a function to be passed
    val squareFunction = { num1: Int -> num1 * num1 }

    // This is an array
    val numberArray = arrayOf(1, 2, 3, 4)

    val callingMathOnList = mathOnList(numberArray, squareFunction)

    println()


    // Collection Operators
    var num : Int = 2
    val num2 : Int = 10


    val numList2 = 1..10
    val listSumUsingReduce = numList2.reduce { x, y -> x + y }
    println("Reduced List Sum : $listSumUsingReduce")      // Outputs 55

    val listSumUsingFold = numList2.fold(5) { x, y -> x + y }
    println("Folded List Sum : $listSumUsingFold")      // Outputs 60 as it starts with an initial value

    // Checking if any of these are even
    println("Evens : ${numList2.any { it % 2 == 0 }}") // Outputs True

    // Checking if all of these are even
    println("Evens : ${numList2.all { it % 2 == 0 }}") // Outputs False

    // Print Item greater than 3
    val big3 = numList2.filter { it > 3 }
    big3.forEach { number -> println("Greater Than 3 : $number") }

    val times7 = numList2.map { it * 7 }
    times7.forEach { n -> println("*7 : $n") }

    // Exception handling :
    val divisor = 2
    try {
        if (divisor == 0) {
            throw IllegalArgumentException("Can't Divide by Zero")
        } else {
            println("5 / $divisor = ${5 / divisor}")
        }
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
    }


    // Types Of Lists :
    // Mutable and Immutable List

    // Mutable List
    var list1: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    // Immutable List
    var list2: List<Int> = listOf(1, 2, 3, 4, 5, 6)

    // Adding and item to Mutable List
    list1.add(6)

    println("First : ${list1.first()} Last : ${list2.last()} ")

    list1[1] = 10
    list1.removeAt(0)
    list1.remove(10)

    // Clear the list
    list1.clear()


    // Maps
    val map = mutableMapOf<Int, Any?>()
    val map2 = mutableMapOf(1 to "DJ", 2 to 2.343, 3 to "Yo")

    // Inserting into Maps
    map[1] = "DEEJAY"
    map[2] = 42
    map[0] = "helo"

    println("Map Size ${map.size}")
    map.put(3, "Yoyo")
    map.remove(1)

    for ((x, y) in map) {
        println("Key : $x Value : $y")
    }


    // Classes

    // Classes are final by default until MARKED AS OPEN and there is no 'Static' in Kotlin
    // See class Animal before proceeding further

    // We have companion objects instead of static :



    val elephantObject = Animal("Elephant", 20.0, 13.5)
    elephantObject.getInfo()


    // Inheriting from a parent class
    val spot = Dog("Spot", 20.0, 14.5, "Deejay Dev")
    spot.getInfo()


    // Third example
    val tweety = Bird("Tweety", true)
    tweety.fly(10.0)


    // Null Safety in Kotlin
    var nullValue: String? = null

    fun returnNull(): String? {
        return null
    }

    var nullVal2 = returnNull()
    if (nullVal2 != null) {
        println(nullVal2.length)
    }

    val person = Person()
    person.setAge(23)
    person.setName("DJ")

}


class Person (firstName : String, personAge : Int){
    val name : String;
    val age : Integer;

    init {
        age = personAge
        name = firstName
    }

    fun getName() : String = name
    fun getAge() : Int = age
    fun setName(String newName) = {this.name = newName}
    fun setAge(Int newAge) = {this.age = newAge}

    override fun toString(): String {
        return super.toString()
    }
}

open class Animal(
    val name: String,
    val height: Double,
    val weight: Double
) {

    init {
        val regex = Regex(".*\\d+,*")
        require(!name.matches(regex)) { "Animal name can't contain number" }
        require(height > 0) { "Height must be greater than 0" }
    }

    open fun getInfo(): Unit {
        println("$name is $height tall and weighs $weight")
    }
}

class Dog(
    name: String,
    height: Double,
    weight: Double,
    var owner: String
) : Animal(name, height, weight) {

    override fun getInfo() {
        println("$name is $height tall and weighs $weight and is owned by an $owner")
    }
}

interface Flyable {
    var flies: Boolean
    fun fly(distMile: Double): Unit
}

class Bird constructor(val name: String, override var flies: Boolean = true) : Flyable {
    override fun fly(distMile: Double) {
        if (flies)
            println("$name flies $distMile miles")
    }
}