class MobileOperatorExtra(
    name: String,
    costMin: Double,
    area: Double,
    var connectionFee: Boolean
) : MobileOperator(name){
    constructor(name: String) : this(name, 0.0, 0.0, false)
    override fun DisplayInfo() {
        super.DisplayInfo()
        println("Плата за соединение: ${if (connectionFee) "да" else "нет"}")
    }
    override fun calculateQuality() : Double {
        if (connectionFee) {
            return 0.7 * super.calculateQuality()
        }
        else {
            return 0.5 * super.calculateQuality()
        }
    }
}