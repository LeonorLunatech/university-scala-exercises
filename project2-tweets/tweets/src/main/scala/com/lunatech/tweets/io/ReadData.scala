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

package com.lunatech.tweets.io

import scala.io.Source
import scala.util.Try
import scala.util.matching.Regex

object ReadData {

  def getFileLines(filename: String): Try[List[String]] = {
    Try(Source.fromFile(filename).getLines().toList)
  }

  def listOfUsers(fileData: List[String]): List[String] = {
    def accumulateUsers(tweets: List[String], users: List[String]): List[String] = {
      tweets match {
        case Nil => users
        case tweet :: tail => {
          val lineInfo = splitLineinUserAndInfo(tweet)

          if (lineInfo.length > 1) {
            val newUsers = users :+ lineInfo(0)
            accumulateUsers(tail, newUsers)
          } else
            users
        }
      }
    }

    accumulateUsers(fileData, List())
  }

  def listOfWords(fileData: List[String]): List[String] = {
    def accumulateWords(tweets: List[String], words: List[String]): List[String] = {
      tweets match {
        case Nil => words
        case tweet :: tail => {
          val lineInfo = splitLineinUserAndInfo(tweet)

          if (lineInfo.length > 1) {
            val newWords = words ++ lineInfo(1).split(" ")
            accumulateWords(tail, newWords)
          } else
            words
        }
      }
    }

    accumulateWords(fileData, List())
  }

  def listOfLinks(fileData: List[String]): List[String] = {
    def accumulateLinks(tweets: List[String], links: List[String]): List[String] = {
      tweets match {
        case Nil => links
        case tweet :: tail => {
          val lineInfo = splitLineinUserAndInfo(tweet)

          if (lineInfo.length > 1) {
            val newLinks = links ++ getLinks(lineInfo(1))
            accumulateLinks(tail, newLinks)
          } else
            links
        }
      }
    }

    accumulateLinks(fileData, List())
  }

  def listOfMentionedUsers(fileData: List[String]): List[String] = {
    def accumulateMentionedUsers(tweets: List[String], users: List[String]): List[String] = {
      tweets match {
        case Nil => users
        case tweet :: tail => {
          val lineInfo = splitLineinUserAndInfo(tweet)

          if (lineInfo.length > 1) {
            val newLinks = users ++ getMentionedUsers(lineInfo(1))
            accumulateMentionedUsers(tail, newLinks)
          } else
            users
        }
      }
    }

    accumulateMentionedUsers(fileData, List())
  }

  private def getLinks(line: String): List[String] = {
    val linkRegex = new Regex("(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
    linkRegex.findAllIn(line).toList
  }

  private def getMentionedUsers(line: String): List[String] = {
    val words = line.split(" ").toList
    words.filter(w => w.startsWith("@"))
  }

  private def splitLineinUserAndInfo(line: String): Array[String] = {
    line split "--"
  }

}
