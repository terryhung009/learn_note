open class Room (val name:String){
    protected open val dangerLevel = 5

    fun description() = "Room:$name\n" +
            "Danger level : $dangerLevel"


    open fun load() = "Nothing much to see here..."

}

class TownSquare : Room("TownSquare"){
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "GWONG"


    final override fun load() = "The villages rally and cheer as you enter!\n${ringBell()}"

    private fun ringBell() ="The bell tower announces your arrival. $bellSound"

}