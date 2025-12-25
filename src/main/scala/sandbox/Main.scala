package sandbox

// import cats.syntax.all.*
import printable.PrintableInstances._
import printable.Printable
import printable.PrintableSyntax._
import cat.Cat

import cats.Show
import cats.instances.int._    // for Show
import cats.instances.string._ // for Show
import cats.syntax.show._ // for show extension method

import cats.Eq
import cats.syntax.eq._



@main
def main(): Unit =
  printableExercise()
  showExercise()
  compareExercise()





def printableExercise(): Unit =
  val stringSeven = "Seven"
  val intSeven = 7
  val cat = Cat("Pepper", 1, "Brown")

  Printable.print(intSeven)
  Printable.print(stringSeven)

  // singleton object print method through Printable object
  Printable.print(cat)
  // print extension method implicit class def w/ a generic constructor
  cat.print

def showExercise(): Unit = 
  // show is the equivalent of Printable implements in cats
  // val showInt: Show[Int] = Show.apply[Int]
  // val showString: Show[String] = Show.apply[String]

  // val intAsString: String = showInt.show(123)
  // val stringAsString: String = showString.show("abc")

  val showInt = 123.show
  val showString = "abc".show
  val cat = Cat("Pepper", 1, "Brown")

  println(s"${showInt}, ${showString}")
  
  implicit val catShow: Show[Cat] = Show.show(cat => s"${cat.name} is a ${cat.age} year-old ${cat.color} cat")

  val showCat = cat.show

  println(showCat)

def compareExercise(): Unit =
  implicit val catEq: Eq[Cat] =
    Eq.instance[Cat] { (cat1, cat2) =>
      cat1.name === cat2.name
      && cat1.age === cat2.age
      && cat1.color === cat2.color
  }

  val cat1 = Cat("Garfield",   38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")

  print(cat1 === cat2)

  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]

  print(optionCat1 === optionCat2)
