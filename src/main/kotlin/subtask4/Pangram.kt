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
