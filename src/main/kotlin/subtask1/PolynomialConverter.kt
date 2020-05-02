package subtask1

import java.lang.StringBuilder
import kotlin.math.absoluteValue

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {

        if(numbers.isNullOrEmpty()) return null

        val result = StringBuilder()
        var pow = numbers.size - 1

        loop@ for((index,value) in numbers.withIndex()) {
            when(index) {
                0 -> {
                    result.append("${value}x^$pow")
                    pow--
                }
                in 1..numbers.size - 2 -> {
                    if(pow == 1) {
                        when(value) {
                            0 -> result.append("")
                            1 -> result.append(" + x")
                            -1 -> result.append(" - x")
                            in 2..Int.MAX_VALUE -> result.append(" + ${value}x")
                            else -> result.append(" - ${value.absoluteValue}x")
                        }
                        continue@loop
                    }
                    else when (value) {
                        0 -> result.append("")
                        1 -> result.append(" + x")
                        -1 -> result.append(" - x")
                        in 2..Int.MAX_VALUE -> result.append(" + ${value}x^$pow")
                        else -> result.append(" - ${value.absoluteValue}x^$pow")
                    }
                    pow--
                }
                else -> {
                    when(value) {
                        in 1..Int.MAX_VALUE -> result.append(" + $value")
                        0 -> result.append("")
                        else -> result.append(" - ${value.absoluteValue}")
                    }
                }
            }
        }

        return result.toString()
    }
}