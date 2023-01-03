const val MAX_EXPERIENCE : Int = 5000

fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    //Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)


    //println (auraColor)

    //Player status
    val healthStatus = formatHeakthStatus(healthPoints, isBlessed)


    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball()

    shouldReturnASTring()


}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String) {
    println("(Aura: $auraColor)" +
            "(Blessed: ${if (isBlessed) "YES" else "NO"} )"
    )
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

private fun castFireball(numFireballs : Int = 2) =
    println("A glass of Fireball springs into existence.(x$numFireballs)")



private fun formatHeakthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> " is in excellent condition!"
        in 90..99 -> " has a few scratches."
        in 75..89 -> if (isBlessed) {
            " has some minor wounds but is healing quite quickly!"
        } else {
            " has some minor wounds."
        }
        in 15..74 -> " looks pretty hurt."
        else -> " is in awful condition!"
    }


fun shouldReturnASTring() : String {
    TODO("implement the string building functionality here to return a string")
    println("unreachable")
}

