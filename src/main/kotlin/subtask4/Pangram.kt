package subtask4

class Pangram {

    val vowels = arrayOf('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y')
    val consonants = arrayOf('b','B','c', 'C', 'd', 'D', 'f', 'F', 'g', 'G', 'h', 'H', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M',
        'n', 'N', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'v', 'V', 'w', 'W', 'x', 'X', 'z', 'Z'
    )


    fun getResult(inputString: String): String {
        var result: String = ""
        val words = inputString.trim().split(' ')
            .filter { it != "" }.filter { it != "\n" }.map { StringBuilder(it) }.toMutableList()

        if (isPangram(inputString)) {
            words.forEachIndexed { indexW, it ->
                var countVowels = 0
                it.forEachIndexed { index, c ->
                    if(c in vowels){
                        it[index] = c.toUpperCase()
                        countVowels++
                    }
                }
                words[indexW] = StringBuilder("$countVowels${it}")
            }
            words.sortBy {
                it[0]
            }
            result = words.joinToString(" ")
        } else {
            words.forEachIndexed { indexW, it ->
                var countVowels = 0
                it.forEachIndexed { index, c ->
                    if(c in consonants){
                        it[index] = c.toUpperCase()
                        countVowels++
                    }
                }
                words[indexW] = StringBuilder("$countVowels${it}")
            }
            words.sortBy {
                it[0]
            }
            result = words.joinToString(" ")
        }


        return result
    }


    fun isPangram(str: String): Boolean {
        val alphabet = mutableSetOf(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        )
        str.forEach {
            alphabet.remove(it.toLowerCase())
        }
        if (alphabet.size == 0) return true

        return false
    }

}


//
//fun getResult(inputString: String): String {
//    val vowels = arrayOf('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y')
//    val consonants = arrayOf('b', 'B', 'c', 'C', 'd', 'D', 'f', 'F',
//        'g', 'G', 'h', 'H', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'p', 'P', 'q', 'Q', 'r', 'R',
//        's', 'S', 't', 'T', 'v', 'V', 'w', 'W', 'x', 'X', 'z', 'Z')
//    var strIsEmpty = true
//    inputString.forEach { if (it != ' ') strIsEmpty = false }
//    if (strIsEmpty) return ""
//    val requiredLetters = if (inputString.isPangram()) vowels else consonants
//    var numOfRequiredLetters = 0
//    val words = inputString.trim().split(' ')
//        .filter { it != "" }.filter { it != "\n" }.map { StringBuilder(it) }.toMutableList()
//    val numsOfRequiredLetters = arrayOfNulls<Int>(words.size)
//    words.forEachIndexed { i, word ->
//        numOfRequiredLetters = 0
//        word.forEachIndexed { index, it ->
//            if (requiredLetters.contains(it)) {
//                words[i][index] = it.toUpperCase()
//                numOfRequiredLetters++
//            }
//        }
//        numsOfRequiredLetters[i] = numOfRequiredLetters
//        words[i] = StringBuilder("$numOfRequiredLetters${words[i]}")
//    }
//    words.sortBy { it[0] }
//    return words.joinToString(" ")
//}
//
//private fun String.isPangram(): Boolean {
//    val alphabet = mutableMapOf('a' to 'A', 'b' to 'B', 'c' to 'C', 'd' to 'D', 'e' to 'E', 'f' to 'F',
//        'g' to 'G', 'h' to 'H', 'i' to 'I', 'j' to 'J', 'k' to 'K', 'l' to 'L', 'm' to 'M', 'n' to 'N',
//        'o' to 'O', 'p' to 'P', 'q' to 'Q', 'r' to 'R', 's' to 'S', 't' to 'T', 'u' to 'U', 'v' to 'V',
//        'w' to 'W', 'x' to 'X', 'y' to 'Y', 'z' to 'Z')
//    this.forEach {
//        if (alphabet.keys.contains(it) || alphabet.values.contains(it)) {
//            alphabet.keys.remove(it)
//            alphabet.values.remove(it)
//        }
//    }
//    return alphabet.isEmpty()
//}
//
//private fun test(required: String, result: String) {
//    println("required: $required")
//    println("result: $result")
//    println("test is passed: ${required == result}\n")
//}