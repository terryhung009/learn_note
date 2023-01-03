import java.io .File

class player(_name:String,
             override var healthPoints:Int = 100,
             val isBlessed:Boolean,
             private val isImmortal:Boolean ): Fightable {
    var name = _name
    get() = "${field.capitalize()} of $hometown"
    private set(value){
        field = value.trim()
    }

    val hometown by lazy {selectHometwon()}
    var currentPosition = Coordinate(0,0)

    private fun selectHometwon() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()

    init{
        require(healthPoints > 0 , { "healthPoints must be greater than zero."})
        require(name.isNotBlank(), {"Player must have a name"})



    }
    constructor(name:String):this(name,
        healthPoints =100,
        isBlessed = true,
        isImmortal = false){
        if(name.toLowerCase() == "kar") healthPoints = 40
    }

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50
        return if (auraVisible) "GREEN" else "NONE"

    }
    fun formatHealthStatus() =
        when (healthPoints){
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches."
            in 75..89 -> if(isBlessed){
                    "has some minor wounds, but is healing quite quickly."
                }else{
                "has some minor wounds."
            }
            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"

        }

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence.(x$numFireballs)")


}