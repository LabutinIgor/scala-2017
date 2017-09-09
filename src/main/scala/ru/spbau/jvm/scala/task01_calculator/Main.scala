package ru.spbau.jvm.scala.task01_calculator

import ru.spbau.jvm.scala.task01_calculator.parsing.{Lexer, Parser}

object Main {

  def main(args: Array[String]): Unit = {
    for (line <- io.Source.stdin.getLines) {
      if (line.equals("exit")) System.exit(0)

      val list = Lexer.parse(line)
      list.foreach(x => println(x.lexeme_type + " " + x.lexeme_value))

      val expression = Parser.parse(Lexer.parse(line))
      println(expression.eval())
    }
  }
}
