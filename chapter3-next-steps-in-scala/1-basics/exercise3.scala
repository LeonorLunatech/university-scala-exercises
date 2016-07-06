// Define the method makeThreeTuple so that the following code compiles:

def makeThreeTuple(a : String, b: String, c: String) : (String, String, String) ={
  (a,b,c)
}

def makeThreeTuple(a : String, b: String, c: Double) : (String, String, Double) ={
  (a,b,c)
}

// Write your answer above this line and don't change the code below this line!
val allStrings = makeThreeTuple("foo", "bar", "buzzz")
val anInt = makeThreeTuple("foo", "bar", 42)
val aDouble: (String, String, Double) = makeThreeTuple("bon", "bini", 3.14159)
