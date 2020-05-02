package subtask5

class TelephoneFinder {

    val resultMas = mutableListOf<String>()

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        val one = listOf('2','4')
        val two = listOf('1','3','5')
        val three = listOf('2','6')
        val four = listOf('1','5','7')
        val five = listOf('2','4','6','8')
        val six = listOf('3','5','9')
        val seven = listOf('4','8')
        val eight = listOf('5','7','9','0')
        val nine = listOf('6','8')
        val zero = listOf('8')

        if(number.matches("[0-9]*".toRegex())) {
            number.forEachIndexed { index, char ->
                when(char) {
                    '0' -> replaceChars(index, number, zero)
                    '1' -> replaceChars(index, number, one)
                    '2' -> replaceChars(index, number, two)
                    '3' -> replaceChars(index, number, three)
                    '4' -> replaceChars(index, number, four)
                    '5' -> replaceChars(index, number, five)
                    '6' -> replaceChars(index, number, six)
                    '7' -> replaceChars(index, number, seven)
                    '8' -> replaceChars(index, number, eight)
                    else -> replaceChars(index, number, nine)
                }
            }
        }
        else return null

        return resultMas.toTypedArray()
    }

    fun replaceChars(index: Int, string: String, neighbors: List<Char>) {

        for(element in neighbors) {
            val str = string.replace(string[index], element)
            resultMas.add(str)
        }
    }
}
