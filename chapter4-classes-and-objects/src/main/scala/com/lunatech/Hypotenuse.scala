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

package com.lunatech

import scala.util.{ Failure, Success, Try }

object Hypotenuse extends App {
  if (args.length != 2) {
    println("Usage: run <Integer> <Integer>")
  } else {
    val a = Try(Integer.parseInt(args(0)))
    val b = Try(Integer.parseInt(args(1)))

    val hypotenuse: Try[Int] =
      for {
        first <- a
        second <- b
      } yield calculateHypotenuse(first, second)

    hypotenuse match {
      case Success(h) => println(h)
      case Failure(e) => println("Numbers only please!")
    }
  }

  def calculateHypotenuse(a: Int, b: Int): Int = {
    Math.sqrt((a * a) + (b * b)).toInt
  }
}

