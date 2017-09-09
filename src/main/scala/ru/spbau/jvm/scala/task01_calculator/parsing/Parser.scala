package ru.spbau.jvm.scala.task01_calculator.parsing

import ru.spbau.jvm.scala.task01_calculator.expressions.named_functions.{PowFunction, SinFunction}
import ru.spbau.jvm.scala.task01_calculator.expressions.operations._
import ru.spbau.jvm.scala.task01_calculator.expressions.{Brackets, ConstExpression, Expression}


object Parser {
  def parse(lexemes: List[Lexeme]): Expression = {
    val pos = findPosOfFirstOperation(lexemes)
    lexemes(pos) match {
      case l if l.lexemeType == LexemeType.BinOp && l.lexemeValue.equals("+") =>
        new BinaryPlus(parse(lexemes.slice(0, pos)), parse(lexemes.slice(pos + 1, lexemes.size)))
      case l if l.lexemeType == LexemeType.BinOp && l.lexemeValue.equals("-") =>
        new BinaryMinus(parse(lexemes.slice(0, pos)), parse(lexemes.slice(pos + 1, lexemes.size)))
      case l if l.lexemeType == LexemeType.BinOp && l.lexemeValue.equals("*") =>
        new BinaryMul(parse(lexemes.slice(0, pos)), parse(lexemes.slice(pos + 1, lexemes.size)))
      case l if l.lexemeType == LexemeType.BinOp && l.lexemeValue.equals("/") =>
        new BinaryDiv(parse(lexemes.slice(0, pos)), parse(lexemes.slice(pos + 1, lexemes.size)))
      case l if l.lexemeType == LexemeType.UnOp && l.lexemeValue.equals("-") =>
        new UnaryMinus(parse(lexemes.tail))
      case l if l.lexemeType == LexemeType.Const =>
        new ConstExpression(lexemes(pos).lexemeValue.toDouble)
      case l if l.lexemeType == LexemeType.Bracket =>
        if (lexemes.head.lexemeValue.equals("(") && lexemes.last.lexemeValue.equals(")")) {
          new Brackets(parse(lexemes.slice(1, lexemes.size - 1)))
        } else {
          throw new IllegalArgumentException()
        }
      case l if l.lexemeType == LexemeType.FunctionName =>
        val args = parseFunctionArgs(lexemes.slice(2, lexemes.size - 1) :+ new Lexeme(LexemeType.Comma, ","))
        l.lexemeValue match {
          case "sin" => new SinFunction(args)
          case "pow" => new PowFunction(args)
          case _ => throw new NoSuchElementException
        }
      case _ => throw new NoSuchElementException
    }
  }

  private def parseFunctionArgs(lexemes: List[Lexeme]): List[Expression] = {
    var arg = List[Lexeme]()
    var args = List[Expression]()
    var balance = 0
    for (i <- lexemes.indices) {
      if (balance == 0 && lexemes(i).lexemeType == LexemeType.Comma) {
        args :+= parse(arg)
        arg = List[Lexeme]()
      } else {
        arg :+= lexemes(i)
      }
      if (lexemes(i).lexemeType == LexemeType.Bracket) {
        if (lexemes(i).lexemeValue == "(") balance += 1 else balance -= 1
      }
    }
    args
  }

  private def findPosOfFirstOperation(lexemes: List[Lexeme]): Int = {
    var balance = 0
    var idMinPriority = -1
    for (i <- lexemes.indices) {
      if (balance == 0 && (idMinPriority == -1 || calcPriority(lexemes(i)) < calcPriority(lexemes(idMinPriority)))) {
        idMinPriority = i
      }
      if (lexemes(i).lexemeType == LexemeType.Bracket) {
        if (lexemes(i).lexemeValue == "(") balance += 1 else balance -= 1
      }
    }
    idMinPriority
  }

  private def calcPriority(lexeme: Lexeme): Int = {
    lexeme match {
      case l if l.lexemeType == LexemeType.BinOp && (l.lexemeValue.equals("+") || l.lexemeValue.equals("-")) => 1
      case l if l.lexemeType == LexemeType.BinOp && (l.lexemeValue.equals("*") || l.lexemeValue.equals("/")) => 2
      case l if l.lexemeType == LexemeType.UnOp && l.lexemeValue.equals("-") => 3
      case _ => 10
    }
  }
}
