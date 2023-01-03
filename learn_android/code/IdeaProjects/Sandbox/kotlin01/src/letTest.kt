fun main(){
    val result = listOf(3,2,1).first().let {
        it * it
    }
println(result)
println(formatGreeting(null))

}

/*fun formatGreeting(guestName:String?):String{
    return guestName?.let{
        "Welcome , $guestName"
    }?: "What's your name?"

}
*/

fun formatGreeting(guestName:String?):String{
    return if(guestName != null){
        "Welcome , $guestName"
    }else{
        "What's your name?"
    }


}