package ru.spbau.jvm.scala.task01_calculator

import ru.spbau.jvm.scala.task01_calculator.parsing.{Lexer, Parser}

object Main {

  def main(args: Array[String]): Unit = {
    for (line <- io.Source.stdin.getLines) {
      if (line.equals("exit")) System.exit(0)

      try {
        val expression = Parser.parse(Lexer.parse(line))
        println(expression.eval())
      } catch {
        case _: IllegalArgumentException => println("Incorrect expression")
        case _: Throwable => println("Something went wrong")
      }
    }
  }
}
