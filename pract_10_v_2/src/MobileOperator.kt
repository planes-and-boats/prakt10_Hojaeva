open class MobileOperator(
    override var name: String,
    override var costMin: Double,
    override var area: Double
) : BaseOperator(), BaseFun {
    constructor(name: String) : this (name, 0.0, 0.0)
    override fun DisplayInfo() {
        println("Название: $name\nСтоимость минуты: $costMin\nПлощадь покрытия: $area")
    }
    override fun calculateQuality() : Double {
        if (costMin != 0.0) {
            return 100 * area / costMin
        }
        else {
            return 0.0
        }
    }
}