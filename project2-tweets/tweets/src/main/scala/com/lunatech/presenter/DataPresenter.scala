/*
 * Copyright 2016 leonorboga
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lunatech.presenter

object DataPresenter {

  def prettyPrintingOfQueryResults(
    listOfUsers: List[(String, Int)],
    listOfWords: List[(String, Int)],
    listOfWordsNoStopWords: List[(String, Int)],
    listOfLinks: List[(String, Int)],
    listOfMentionedUsers: List[(String, Int)]
  ) = {

    val totalPadding = 35

    println("")
    println("")
    println("Tweets Report")
    println("-------------")
    println("")
    println("Most active users:")
    for (line <- listOfUsers) {
      println(formatLine(line._1, line._2, totalPadding))
    }
    println("")

    println("Most used words:")
    for (line <- listOfWords) {
      println(formatLine(line._1, line._2, totalPadding))
    }
    println("")

    println("Most used words, excluding stop-words:")
    for (line <- listOfWordsNoStopWords) {
      println(formatLine(line._1, line._2, totalPadding))
    }
    println("")

    println("Most mentioned links:")
    for (line <- listOfLinks) {
      println(formatLine(line._1, line._2, totalPadding))
    }
    println("")

    println("Most mentioned users:")
    for (line <- listOfMentionedUsers) {
      println(formatLine(line._1, line._2, totalPadding))
    }
    println("")
  }

  private def formatLine(data: String, count: Int, padding: Int): String = {
    val builder = new StringBuilder()

    builder.append("*")
    builder.append(" ")
    builder.append(data)
    val paddingOffset = padding - data.length

    for (x <- 1 until paddingOffset) {
      builder.append(" ")
    }
    builder.append(count)
    builder.toString
  }

}
