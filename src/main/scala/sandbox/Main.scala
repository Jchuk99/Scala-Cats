package sandbox

// import cats.syntax.all.*
import printable.PrintableInstances._
import printable.Printable

@main
def main(): Unit =
  Printable.print(7)
  Printable.print("Seven")
