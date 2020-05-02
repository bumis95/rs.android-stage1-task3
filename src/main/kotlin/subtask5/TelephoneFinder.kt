package subtask5

class TelephoneFinder {

    val resultMas = mutableListOf<String>()

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        if(number.matches("[0-9]*".toRegex())) {
            number.forEachIndexed { index, char ->
                when(char) {
                    '0' -> replaceChars(index, number, listOf('8'))
                    '1' -> replaceChars(index, number, listOf('2','4'))
                    '2' -> replaceChars(index, number, listOf('1','3','5'))
                    '3' -> replaceChars(index, number, listOf('2','6'))
                    '4' -> replaceChars(index, number, listOf('1','5','7'))
                    '5' -> replaceChars(index, number, listOf('2','4','6','8'))
                    '6' -> replaceChars(index, number, listOf('3','5','9'))
                    '7' -> replaceChars(index, number, listOf('4','8'))
                    '8' -> replaceChars(index, number, listOf('5','7','9','0'))
                    else -> replaceChars(index, number, listOf('6','8'))
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
