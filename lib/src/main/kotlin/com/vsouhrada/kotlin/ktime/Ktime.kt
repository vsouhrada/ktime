package com.vsouhrada.kotlin.ktime

import java.sql.Date
import java.time.*
import java.time.temporal.ChronoUnit

/**
 *
 * @author vsouhrada
 * @version 0.1.0
 * @since 0.1.0
 */

object today

object firstSecond
object lastSecond
object months

/**
 * Convert [Date] to [LocalDateTime]
 * @return the new [LocalDateTime] object created from [Date]
 * @since 0.1.0
 */
fun Date.toLocalDateTime() = Instant.ofEpochMilli(this.time).atZone(ZoneId.systemDefault()).toLocalDateTime()

/**
 * Convert [Date] to [LocalDate]
 * @return the new [LocalDate] object created from [Date]
 * @since 0.1.0
 */
fun Date.toLocalDate() = Instant.ofEpochMilli(this.time).atZone(ZoneId.systemDefault()).toLocalDate()

/**
 * Convert [LocalDateTime] to [Date]
 * @return the new [Date] object created from [LocalDateTime]
 * @since 0.1.0
 */
fun LocalDateTime.toSqlDate() = Date.valueOf(this.toLocalDate())

/**
 * Convert [LocalDate] to [Date]
 * @return the new [Date] object created from [LocalDate]
 * @since 0.1.0
 */
fun LocalDate.toSqlDate() = Date.valueOf(this)

/**
 * Return the minimum supported {@code LocalTime}, '00:00'.
 * This is the time of midnight at the start of the day.
 * @return  The minimum supported {@code LocalTime}, '00:00'.
 * @since 0.1.0
 */
infix fun LocalDateTime.at(firstSecond: firstSecond) = LocalDateTime.of(this.toLocalDate(), LocalTime.MIN)

/**
 * The maximum supported {@code LocalTime}, '23:59:59.999999999'.
 * This is the time just before midnight at the end of the day.
 * @return  The maximum supported {@code LocalTime}, '23:59:59.999999999'.
 * @since 0.1.0
 */
infix fun LocalDateTime.at(lastSecond: lastSecond) = LocalDateTime.of(this.toLocalDate(), LocalTime.MAX)

/**
 * Return the minimum supported {@code LocalTime}, '00:00'.
 * This is the time of midnight at the start of the day.
 * @return  The minimum supported {@code LocalTime}, '00:00'.
 * @since 0.1.0
 */
infix fun LocalDate.at(firstSecond: firstSecond) = LocalDateTime.of(this, LocalTime.MIN)

/**
 * The maximum supported {@code LocalTime}, '23:59:59.999999999'.
 * This is the time just before midnight at the end of the day.
 * @return  The maximum supported {@code LocalTime}, '23:59:59.999999999'.
 * @since 0.1.0
 */
infix fun LocalDate.at(lastSecond: lastSecond) = LocalDateTime.of(this, LocalTime.MAX)

/**
 * This extension function of the [LocalDate] return count of months between start date ([LocalDate] on which is call this extension method) and [endDate]
 * @return count of months between start date ([LocalDate] on which is call this extension method) and [endDate]
 * @since 0.1.0
 */
infix fun LocalDate.months(endDate: LocalDate) = ChronoUnit.MONTHS.between(this, endDate)

/**
 * This extension function of the [LocalDateTime] return count of months between start date ([LocalDateTime] on which is call this extension method) and [endDate]
 * @return count of months between start date ([LocalDateTime] on which is call this extension method) and [endDate]
 * @since 0.1.0
 */
infix fun LocalDateTime.months(endDate: LocalDateTime) = ChronoUnit.MONTHS.between(this, endDate)

infix fun today.at(start: lastSecond) = currentTime()

private fun currentDate() = LocalDate.now()

private fun currentTime() = LocalDateTime.now()

//infix fun months.between(startDate: LocalDate, endDate: LocalDate) = ChronoUnit.MONTHS.between(startDate, endDate)

//fun Date.toLocalDateTime() = LocalDateTime.from(this.toLocalDate())