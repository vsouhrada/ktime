package com.vsouhrada.kotlin.ktime

import java.time.LocalDate

fun main(args: Array<String>) {
  val day = LocalDate.of(2016, 12, 11)
  val beginDateTime = day at firstSecond
  val endDateTime = day at lastSecond


  println("Date $day start at $beginDateTime and end at $endDateTime")
  // Date 2016-12-11 start at 2016-12-11T00:00 and end at 2016-12-11T23:59:59.999999999
}