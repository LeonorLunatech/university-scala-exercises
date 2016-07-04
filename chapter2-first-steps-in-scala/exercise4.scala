// Compute the sum of the uneven numbers from 1 to 100


val range = Range(1, 100, 2)
var sum = 0

range.foreach(a => sum += a )

println(sum)
