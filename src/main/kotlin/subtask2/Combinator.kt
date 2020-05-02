package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        // c = n! / (n-m)! * m!
        val c = array[0]
        val n = array[1]
        if(n <= 0) return null
        for(m in 0..n)
            if(c * factorial(n-m) * factorial(m) == factorial(n)) return m
        return null
    }

    fun factorial(n: Int) = (2..n).fold(1L, Long::times)
}
