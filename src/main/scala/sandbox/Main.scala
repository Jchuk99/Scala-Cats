package sandbox

// import cats.syntax.all.*
import printable.PrintableInstances._
import printable.Printable
import printable.PrintableSyntax._
import cat.Cat

@main
def main(): Unit =
  val stringSeven = "Seven"
  val intSeven = 7
  val cat = Cat("Pepper", 1, "Brown")

  Printable.print(intSeven)
  Printable.print(stringSeven)

  // singleton object print method through Printable object
  Printable.print(cat)
  // print extension method implicit class def w/ a generic constructor
  cat.print
