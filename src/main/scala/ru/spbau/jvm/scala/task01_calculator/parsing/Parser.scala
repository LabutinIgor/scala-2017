package ru.spbau.jvm.scala.task01_calculator.parsing

import ru.spbau.jvm.scala.task01_calculator.expressions.{ConstExpression, Expression}


object Parser {
  def parse(lexemes: List[Lexeme]): Expression = {
    new ConstExpression(0)
  }
}
