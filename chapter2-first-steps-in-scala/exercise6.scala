// Like an array, you can also use a Range on the right hand side of an '<-' in a for-loop.
// Can you rewrite the previous program with a for-loop?

for (elem <- Range(1,101)) {
  val multipleOfthree = elem % 3 == 0
  val multipleOfFive = elem % 5 == 0

  if(multipleOfthree && multipleOfFive)
    println("FizzBuzz")
  else if(multipleOfthree)
    println("Fizz")
  else if(multipleOfFive)
    println("Buzz")
  else
    println(elem)
}