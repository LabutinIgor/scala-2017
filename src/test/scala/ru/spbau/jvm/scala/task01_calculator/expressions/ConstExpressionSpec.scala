package ru.spbau.jvm.scala.task01_calculator.expressions

import ru.spbau.jvm.scala.task01_calculator.UnitSpec

class ConstExpressionSpec extends UnitSpec {
  "A ConstExpression" should "Return const" in {
    val constExpression = new ConstExpression(42)
    constExpression.eval() shouldEqual 42
  }
}
