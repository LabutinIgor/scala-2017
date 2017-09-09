package ru.spbau.jvm.scala.task01_calculator.parsing

object LexemeType extends Enumeration {
  val BinOp, UnOp, FunctionName, Bracket, Comma, Const = Value
}

class Lexeme(val lexeme_type: LexemeType.Value, val lexeme_value: String) {
}
