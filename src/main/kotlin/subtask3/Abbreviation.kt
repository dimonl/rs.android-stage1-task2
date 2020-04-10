package subtask3

class Abbreviation {

    val strYes = "YES"
    val strNo = "NO"
    fun abbreviationFromA(a: String, b: String): String {

        val masA = a.toCharArray()
        val masB = b.toCharArray()
        var i = 0
        for(elem in masA){
            if(elem == masB[i] || elem.toUpperCase() == masB[i]){
                if(i==masB.size-1){return strYes}
                i++
            }
        }
        return strNo
    }
}
