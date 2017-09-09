package ru.spbau.jvm.scala.task01_calculator.parsing

object LexemeType extends Enumeration {
  val BinOp, UnOp, FunctionName, Bracket, Comma, Const = Value
}

class Lexeme(val lexemeType: LexemeType.Value, val lexemeValue: String) {
}
