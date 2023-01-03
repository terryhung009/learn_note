fun main(){
//    val name = "Madrigal"





    Game.play()





}



object Game{

    var player = player("Madrigal")
    private class GameInput(arg:String?){
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1,{""})

        fun processCommand()= when (command.toLowerCase()){
            else ->commandNotFound()
        }
        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }

    var currentRoom:Room = TownSquare()
    init{
        println("Welcome, adventurer.")
        player.castFireball()
    }

    fun play(){
        while(true){
            //play NyetHack
            println(currentRoom.description())
            println(currentRoom.load())

            //Aura
//    val auraColor = player.auraColor()

            //Player status
            printPlayerStatus(player)

            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
        }
    }
    private fun printPlayerStatus(player:player){
        println("(Aura: ${player.auraColor()})" + "(Blessed : ${if(player.isBlessed) "YES" else "NO" })")
        println("${player.name} ${player.formatHealthStatus()}")


    }



}
