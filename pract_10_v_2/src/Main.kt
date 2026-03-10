fun main() {
    try {
        var operators = Array(3) {i ->
            when (i) {
                0 -> MobileOperator("")
                1 -> MobileOperatorExtra("")
                else -> Man("")
            }
        }
        for (i in 0..2) {
            var item = operators[i]
            when(item) {
                is MobileOperatorExtra -> {
                    println("--- Создание объекта класса-наследника: ---")
                    print("Введите название: ")
                    item.name = readln()
                    do {
                        print("Введите плату за 1 минуту (> -1): ")
                        item.costMin = readln().toDouble()
                        print("Введите площадь покрытия (> -1): ")
                        item.area = readln().toDouble()
                    } while(item.costMin < 0 || item.area < 0)
                    println("Плата за соединение:\n1 - нет\n2 - да\n(любая другая клавиша - да)")
                    item.connectionFee = readln().toDouble() != 1.0
                }
                is MobileOperator -> {
                    println("--- Создание объекта базового класса: ---")
                    print("Введите название: ")
                    item.name = readln()
                    do {
                        print("Введите плату за 1 минуту (> -1): ")
                        item.costMin = readln().toDouble()
                        print("Введите площадь покрытия (> -1): ")
                        item.area = readln().toDouble()
                    } while(item.costMin < 0 || item.area < 0)
                }
                is Man -> {
                    println("--- Создание объекта независимого класса: ---")
                    print("Введите имя: ")
                    item.name = readln()
                    print("Введите фамилию: ")
                    item.surname = readln()
                    print("Введите планету: ")
                    item.planet = readln()
                    println("Удачливый:\n1 - да\n2 - нет\n(любая другая клавиша - нет)")
                    item.isLuckMan = readln().toDouble() == 1.0
                }
            }
        }
        println("--- Вывод информации ---")
        for (i in 0..2) {
            println("< Объект ${i + 1} >")
            operators[i].DisplayInfo()
            when (operators[i]) {
                is MobileOperator -> println("Качество: ${"%.2f".format(operators[i].calculateQuality())}")
                is Man -> println("Удача сегодня: ${"%.2f".format(operators[i].calculateQuality())} %")
            }
        }
    }
    catch (e:NumberFormatException) {
        println("некорректный формат данных")
    }
}