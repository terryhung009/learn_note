fun main(args:Array<String>){
    val info : Info = Info()
    info.initData()
    println(info.person.swim()  )
}

class Info {
    lateinit var person : Person
    fun initData() {
        person = Person()
    }
}

class Person{
    fun swim() {
        println("人會游泳...")

    }

}