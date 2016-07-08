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

import org.scalatest.{ FlatSpec, Matchers }

class PrimesSpec extends FlatSpec with Matchers {

  "Primes" should "return empty list" in {
    Primes.getPrimeNumbersUntil_Algorithm(-10) shouldBe List()
    Primes.getPrimeNumbersUntil_Algorithm(0) shouldBe List()
    Primes.getPrimeNumbersUntil_Algorithm(1) shouldBe List()
  }

  "Primes" should "return prime numbers" in {
    Primes.getPrimeNumbersUntil_Algorithm(2) shouldBe List(2)
    Primes.getPrimeNumbersUntil_Algorithm(3) shouldBe List(2, 3)
    Primes.getPrimeNumbersUntil_Algorithm(10) shouldBe List(2, 3, 5, 7)
    Primes.getPrimeNumbersUntil_Algorithm(20) shouldBe List(2, 3, 5, 7, 11, 13, 17, 19)
  }

}
