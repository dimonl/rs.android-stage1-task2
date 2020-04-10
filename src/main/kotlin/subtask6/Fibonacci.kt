package subtask6

class Fibonacci {

    var oneEl:Int=0
    var secondEl:Int=1
    fun productFibonacciSequenceFor(n: Int): IntArray {
        while (true){
            when {
                (oneEl*secondEl == n) -> return intArrayOf(oneEl,secondEl,1)
                (oneEl*secondEl > n) -> return intArrayOf(oneEl,secondEl,0)
                else -> {
                    var temp = oneEl
                    oneEl = secondEl
                    secondEl = secondEl+temp
                }
            }
        }
    }
}
