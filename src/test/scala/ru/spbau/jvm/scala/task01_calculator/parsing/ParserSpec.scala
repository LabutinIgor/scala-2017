package ru.spbau.jvm.scala.task01_calculator.parsing

import ru.spbau.jvm.scala.task01_calculator.UnitSpec
import ru.spbau.jvm.scala.task01_calculator.expressions.ConstExpression
import ru.spbau.jvm.scala.task01_calculator.expressions.operations.BinaryMul

class ParserSpec extends UnitSpec {
  "A Parser" should "parse const expression" in {
    val expression = Parser.parse(List(new Lexeme(LexemeType.Const, "42")))
    assert(expression.isInstanceOf[ConstExpression])
    expression.eval() shouldEqual 42
  }

  "A Parser" should "parse expression with operations -2*(3+3)/3" in {
    val lexemes = List(
      new Lexeme(LexemeType.UnOp, "-"), new Lexeme(LexemeType.Const, "2"),
      new Lexeme(LexemeType.BinOp, "*"), new Lexeme(LexemeType.Bracket, "("),
      new Lexeme(LexemeType.Const, "3"), new Lexeme(LexemeType.BinOp, "+"),
      new Lexeme(LexemeType.Const, "3"), new Lexeme(LexemeType.Bracket, ")"),
      new Lexeme(LexemeType.BinOp, "/"), new Lexeme(LexemeType.Const, "3"))
    val expression = Parser.parse(lexemes)
    assert(expression.isInstanceOf[BinaryMul])
    expression.eval() shouldEqual -4
  }

  "A Parser" should "throw IllegalArgumentException if expression is incorrect" in {
    val lexemes = List(
      new Lexeme(LexemeType.UnOp, "-"), new Lexeme(LexemeType.Const, "2"),
      new Lexeme(LexemeType.BinOp, "*"))
    assertThrows[IllegalArgumentException] {
      Parser.parse(lexemes)
    }
  }
}
