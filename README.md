# ktime
Kotlin extension (utilities) for Java time API and others utilities with date and time 
```kotlin
val day = LocalDate.of(2016, 12, 11)
val beginDateTime = day at firstSecond
val endDateTime = day at lastSecond


println("Date $day start at $beginDateTime and end at $endDateTime")
// Date 2016-12-11 start at 2016-12-11T00:00 and end at 2016-12-11T23:59:59.999999999
```