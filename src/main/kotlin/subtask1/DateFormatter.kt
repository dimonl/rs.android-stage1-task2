package subtask1

import java.time.DateTimeException
import java.time.LocalDate


class DateFormatter {
    val days = mapOf("sunday" to "воскресенье","monday" to "понедельник",
                        "tuesday" to "вторник","wednesday" to "средв",
                        "thursday" to "четверг","friday" to "пятница",
                        "saturday" to "суббота")
    val months = mapOf("january" to "января","february" to "февраля",
                      "march" to "марта","april" to "апреля",
                      "may" to "мая","june" to "июня",
                      "july" to "июля","august" to "августа",
                      "september" to "сентября","october" to "октября",
                      "november" to "ноября","december" to "декабря")
    val dateError = "Такого дня не существует";
    fun toTextDay(day: String, month: String, year: String): String {

        var mon: String;
        if(month.length == 1) {mon = "0" +month;} else {mon = month;};


       try {
           val date = LocalDate.parse("$year-$mon-$day")
           var dayWeek = days.getValue(date.dayOfWeek.toString().toLowerCase());
           var dateMonth = months.getValue(date.month.toString().toLowerCase());
           return date.dayOfMonth.toString() + " " + dateMonth +  ", " + dayWeek;

       } catch (e: DateTimeException){
           return dateError
       }

    }
}
