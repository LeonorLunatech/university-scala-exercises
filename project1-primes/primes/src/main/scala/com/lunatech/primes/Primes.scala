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

package com.lunatech.primes

object Primes {

  def getPrimeNumbersUntil_JustFilter(input: Int): List[Int] = {

    val firstPrimeNumber = 2

    // all multiples of two are know to not be a prime, start on 3 and skip all even numbers
    val list = Range(3, input + 1, 2).toList

    for (elem <- list) {
      list.filter({
        _ % elem != 0
      })
    }

    firstPrimeNumber :: list
  }

  def getPrimeNumbersUntil_Algorithm(input: Int): List[Int] = {

    val rangeInit = 3
    val firstPrimeNumber = 2

    if (input <= 1)
      return List()

    if (input == firstPrimeNumber)
      return List(firstPrimeNumber)

    val getNotMarkedValues = new PartialFunction[(Int, Boolean), Int] {
      def apply(x: (Int, Boolean)) = x._1
      def isDefinedAt(x: (Int, Boolean)) = !x._2
    }

    // all multiples of two are know to not be a prime, start on 3 and skip all even numbers
    val list = Range(rangeInit, input + 1, 2).toList
    var listWithMarks = list.map({ x => (x, false) })

    var current: Option[(Int, Boolean)] = Some(listWithMarks.head)

    while (current.isDefined) {
      listWithMarks = listWithMarks.map({
        case (n, b) => if (n > current.get._1 && !b)
          (n, n % current.get._1 == 0)
        else (n, b)
      })

      current = listWithMarks.find({ x => !x._2 && x._1 > current.get._1 })
    }

    firstPrimeNumber :: listWithMarks.collect(getNotMarkedValues)
  }

}