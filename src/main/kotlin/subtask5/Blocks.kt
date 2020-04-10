package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        var sum = 0
        var mas = blockA.filter {
            it!!::class == blockB
        }

        return when(blockB){
            Int::class -> mas.sumBy { it as Int}
            String::class -> mas.joinToString("")
            LocalDate::class -> returnNearestDate(mas as List<LocalDate>)
            else -> ""
        }
    }

    fun returnNearestDate(elements:List<LocalDate>): String{
        val sortedL = elements.sorted()
        return sortedL.last().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    }
}
