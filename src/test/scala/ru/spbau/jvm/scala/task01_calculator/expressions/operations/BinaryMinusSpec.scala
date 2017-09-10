package ru.spbau.jvm.scala.task01_calculator.expressions.operations

import ru.spbau.jvm.scala.task01_calculator.UnitSpec
import ru.spbau.jvm.scala.task01_calculator.expressions.ConstExpression

class BinaryMinusSpec extends UnitSpec {
  "A BinaryMinus" should "Return 10-2=8" in {
    val minusExpression = new BinaryMinus(new ConstExpression(10), new ConstExpression(2))
    minusExpression.eval() shouldEqual 8
  }
}
