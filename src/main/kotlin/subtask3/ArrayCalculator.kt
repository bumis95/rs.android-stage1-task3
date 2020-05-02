package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {

        val onlyInts = itemsFromArray.filterIsInstance<Int>()

        when {
            onlyInts.isEmpty() -> return 0
            numberOfItems >= onlyInts.size -> return onlyInts.fold(1) { start, item -> start * item }
            else -> {
                val positive = onlyInts.filter { it > 0 }
                val negative = onlyInts.filter { it < 0 }

                if(negative.size >= 2) {
                    val maxP = positive
                        .sortedBy { it }
                        .takeLast(2)
                        .fold(1) { start, item -> start * item }
                    val maxN = negative
                        .sortedBy { it.absoluteValue }
                        .takeLast(2)
                        .fold(1) { start, item -> start * item }
                    if(maxN > maxP) {
                        return if(numberOfItems == 2) {
                            maxN
                        } else {
                            positive
                                .sortedBy { it }
                                .takeLast(numberOfItems - 2)
                                .fold(1) { start, item -> start * item } * maxN
                        }
                    }
                }

                return positive
                    .sortedBy { it }
                    .takeLast(numberOfItems)
                    .fold(1) { start, item -> start * item }
            }
        }
    }
}