// Write a program that prints the numbers from 1 to 100. But for multiples of three print
// “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which
// are multiples of both three and five print “FizzBuzz”.

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