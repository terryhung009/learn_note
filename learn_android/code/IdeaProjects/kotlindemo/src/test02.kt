fun varibaleTest(){
    var data : Any = Any()
    //相當於getData()
    var a = data
    println("a"+a.toString())
    println("data"+data.toString()  )

    //相當於setData()
    data = Any()
    println("data"+data.toString()  )
}
fun main(args:Array<String>) {
    varibaleTest()
}