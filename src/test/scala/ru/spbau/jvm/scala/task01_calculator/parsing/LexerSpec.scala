package ru.spbau.jvm.scala.task01_calculator.parsing

import ru.spbau.jvm.scala.task01_calculator.{UnitSpec, parsing}

class LexerSpec extends UnitSpec {

  "A Lexer" should "parse const expression" in {
    val lexemes = Lexer.parse("42")
    lexemes should have length 1
    lexemes.head shouldEqual new Lexeme(LexemeType.Const, "42")
  }

  "A Lexer" should "parse expression with operations" in {
    val lexemes = Lexer.parse("-2*(3+3) / 3 ")
    lexemes should have length 10
    lexemes should contain theSameElementsAs List(
      new Lexeme(LexemeType.UnOp, "-"), new Lexeme(LexemeType.Const, "2"),
      new Lexeme(LexemeType.BinOp, "*"), new Lexeme(LexemeType.Bracket, "("),
      new Lexeme(LexemeType.Const, "3"), new Lexeme(LexemeType.BinOp, "+"),
      new Lexeme(LexemeType.Const, "3"), new Lexeme(LexemeType.Bracket, ")"),
      new Lexeme(LexemeType.BinOp, "/"), new Lexeme(LexemeType.Const, "3"))
  }

  "A Lexer" should "parse expression with functions" in {
    val lexemes = Lexer.parse("sin(pow(sin(1), 3))")
    lexemes should have length 12
    lexemes should contain theSameElementsAs List(
      new Lexeme(LexemeType.FunctionName, "sin"), new Lexeme(LexemeType.Bracket, "("),
      new Lexeme(LexemeType.FunctionName, "pow"), new Lexeme(LexemeType.Bracket, "("),
      new Lexeme(LexemeType.FunctionName, "sin"), new Lexeme(LexemeType.Bracket, "("),
      new Lexeme(LexemeType.Const, "1"), new Lexeme(LexemeType.Bracket, ")"),
      new Lexeme(LexemeType.Comma, ","), new Lexeme(LexemeType.Const, "3"),
      new Lexeme(LexemeType.Bracket, ")"), new Lexeme(LexemeType.Bracket, ")"))
  }
}
