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

import com.lunatech.primes.Primes
import scala.util.{ Failure, Success, Try }

object Main {

  def main(args: Array[String]): Unit =
    {
      // testar se o argumento eh um numero?
      if (args.length != 1) {
        println("Wrong argument input! Please use a positive integer. Example run 20")
      } else {
        val parsedValue = Try(Integer.parseInt(args(0)))
        parsedValue match {
          case Success(n) =>
            println(Primes.getPrimeNumbersUntil_Algorithm(n).mkString(", "))
          case Failure(e) => println("Wrong argument input! Please use a positive integer. Example: run 20")
        }
      }
    }
}