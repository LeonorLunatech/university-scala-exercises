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

package com.lunatech.main

import com.lunatech.presenter.DataPresenter
import com.lunatech.tweets.business.Statistics
import com.lunatech.tweets.io.ReadData

import scala.util.{ Failure, Success }

object Main {

  def main(args: Array[String]) = {

    if (args.length != 1) {
      println("Incorrect number of parameters!!")
      println("Usage: run tweetsFilename.txt")
    } else {

      val fileLines = ReadData.getFileLines(args(0))

      fileLines match {
        case Success(v) => getStatistics(v)
        case Failure(e) => println(e.getMessage)
      }
    }
  }

  private def getStatistics(fileLines: List[String]) =
    {
      val listOfUsers = Statistics.getOrderedListOfUsersByNumberOfTweets(fileLines, 5)
      val listOfWords = Statistics.getOrderedListOfWordsByCount(fileLines, 5)
      val listOfWordsNoStopWords = Statistics.getOrderedListOfWordsWithouStopWordsByCount(fileLines, 5)
      val listOfLinks = Statistics.getOrderedListOfLinksByCount(fileLines, 3)
      val listOfMentionedUsers = Statistics.getOrderedListOfMentionedUsersByCount(fileLines, 8)

      DataPresenter.prettyPrintingOfQueryResults(listOfUsers, listOfWords, listOfWordsNoStopWords, listOfLinks, listOfMentionedUsers)
    }
}
