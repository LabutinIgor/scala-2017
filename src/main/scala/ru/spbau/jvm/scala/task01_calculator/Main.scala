package ru.spbau.jvm.scala.task01_calculator

import ru.spbau.jvm.scala.task01_calculator.parsing.{Lexeme, LexemeType, Lexer, Parser}

object Main {

  def main(args: Array[String]): Unit = {
    for (line <- io.Source.stdin.getLines) {
      if (line.equals("exit")) System.exit(0)
      val expression = Parser.parse(Lexer.parse(line))
      println(expression.eval())
    }
  }
}
