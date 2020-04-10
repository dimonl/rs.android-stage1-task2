package subtask2

class TimeConverter {
    val hours: Array<String> = arrayOf("","one", "two","three", "four","five", "six","seven", "eight","nine", "ten","eleven", "twelve")
    val minutes: Array<String> = arrayOf("","one", "two","three", "four","five", "six","seven", "eight","nine", "ten","eleven", "twelve",
        "thirteen","fourteen", "fifteen","sixteen", "seventeen","eighteen", "nineteen","twenty", "twenty one","twenty two", "twenty three","twenty four", "twenty five",
        "twenty six","twenty seven", "twenty eight","twenty nine")

    fun toTextFormat(hour: String, minute: String): String {
        val hourToStr = hours[hour.toInt()]
        val minuteInt = minute.toInt()
        //val minuteStr = minutes[minute.toInt()]
        var result = ""
        when (minuteInt){
            0 -> result = "$hourToStr o' clock"
            1 -> result = "${minutes[minute.toInt()]} minute past $hourToStr"
            15 -> result = "quarter past $hourToStr"
            30 -> result = "half past $hourToStr"
            45 -> result = "quarter to ${hours[hour.toInt()+1]}"


            in 2..30 -> result = "${minutes[minute.toInt()]} minutes past $hourToStr"
            in 31..60 -> result = "${minutes[60-minute.toInt()]} minutes to ${hours[hour.toInt()+1]}"
        }

        return result
    }
}
