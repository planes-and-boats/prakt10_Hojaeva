import kotlin.random.Random
class Man (
    var name: String,
    var surname: String,
    var planet: String,
    var isLuckMan : Boolean
    ) : BaseFun {
    constructor(name: String) : this (name, "неизвестно", "неизвестно", false)
    override fun DisplayInfo() {
        println("Имя: $name\nПланета: $planet\nФамилия: $surname\nУдачливый: ${if (isLuckMan) "да" else "нет"}")
    }
    override fun calculateQuality(): Double {
        if (isLuckMan)  return Random.nextDouble(40.0, 101.0)
        else return Random.nextDouble(0.0, 51.0)
    }
}