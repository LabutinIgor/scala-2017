package ru.spbau.jvm.scala.task01_calculator.parsing

object Lexer {
  var currentPos = 0

  def parse(line: String): List[Lexeme] = {
    currentPos = 0
    var lexems: List[Lexeme] = List[Lexeme]()
    while (currentPos < line.length) {
      if (line(currentPos) != ' ') {
        lexems :+= (line(currentPos) match {
          case '(' | ')' => new Lexeme(LexemeType.Bracket, "" + line(currentPos))
          case ',' => new Lexeme(LexemeType.Comma, ",")
          case c if c >= '0' && c <= '9' => new Lexeme(LexemeType.Const, parseConst(line))
          case c if c >= 'a' && c <= 'z' => new Lexeme(LexemeType.FunctionName, parseFunctionName(line))
          case _ if currentPos == 0 || line(currentPos - 1) == '(' => new Lexeme(LexemeType.UnOp, "" + line(currentPos))
          case _ => new Lexeme(LexemeType.BinOp, "" + line(currentPos))
        })
      }
      currentPos += 1
    }
    lexems
  }

  private def parseConst(line: String): String = {
    var res = ""
    while (currentPos < line.length &&
      (line(currentPos) == '.' || line(currentPos) >= '0' && line(currentPos) <= '9')) {

      res += line(currentPos)
      currentPos += 1
    }
    currentPos -= 1
    res
  }

  private def parseFunctionName(line: String): _root_.scala.Predef.String = {
    var res = ""
    while (currentPos < line.length && line(currentPos) >= 'a' && line(currentPos) <= 'z') {
      res += line(currentPos)
      currentPos += 1
    }
    currentPos -= 1
    res
  }
}
