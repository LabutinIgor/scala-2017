package ru.spbau.jvm.scala.task01_calculator.parsing

object LexemeType extends Enumeration {
  val BinOp, UnOp, FunctionName, Bracket, Comma, Const = Value
}

class Lexeme(val lexemeType: LexemeType.Value, val lexemeValue: String) {
  override def equals(that: Any): Boolean =
    that match {
      case that: Lexeme => that.isInstanceOf[Lexeme] && that.lexemeValue.equals(this.lexemeValue) &&
        that.lexemeType.equals(this.lexemeType)
      case _ => false
    }
}
