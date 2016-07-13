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

package com.lunatech.tweets.business

import com.lunatech.tweets.io.ReadData

object Statistics {
  def getOrderedListOfUsersByNumberOfTweets(fileData: List[String], num: Int): List[(String, Int)] = {

    val allUsers = ReadData.listOfUsers(fileData)
    allUsers.groupBy(user => user).mapValues(_.size).toList.sortBy(-_._2).take(num)
  }

  def getOrderedListOfWordsByCount(fileData: List[String], num: Int): List[(String, Int)] = {

    val allWords = ReadData.listOfWords(fileData)
    allWords.groupBy(word => word).filterKeys(filterNonWords).mapValues(_.size).toList.sortBy(-_._2).take(num)
  }

  def getOrderedListOfWordsWithouStopWordsByCount(fileData: List[String], num: Int): List[(String, Int)] = {

    val allWords = ReadData.listOfWords(fileData)
    allWords.groupBy(word => word).filterKeys(filterStopWords).mapValues(_.size).toList.sortBy(-_._2).take(num)
  }

  def getOrderedListOfLinksByCount(fileData: List[String], num: Int): List[(String, Int)] = {

    val allWords = ReadData.listOfLinks(fileData)
    allWords.groupBy(word => word).mapValues(_.size).toList.sortBy(-_._2).take(num)
  }

  def getOrderedListOfMentionedUsersByCount(fileData: List[String], num: Int): List[(String, Int)] = {

    val allWords = ReadData.listOfMentionedUsers(fileData)
    allWords.groupBy(word => word).mapValues(_.size).toList.sortBy(-_._2).take(num)
  }

  private def filterNonWords(word: String): Boolean = {
    !(word.trim.length == 0 ||
      word.startsWith(".") ||
      word.startsWith("―"))
  }

  private def filterStopWords(word: String): Boolean = {
    word.length > 2
  }
}
