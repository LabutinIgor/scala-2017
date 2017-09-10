package ru.spbau.jvm.scala.task01_calculator.expressions.operations

import ru.spbau.jvm.scala.task01_calculator.UnitSpec
import ru.spbau.jvm.scala.task01_calculator.expressions.ConstExpression

class BinaryPlusSpec extends UnitSpec {
  "A BinaryPlus" should "Return 2+3=5" in {
    val plusExpression = new BinaryPlus(new ConstExpression(2), new ConstExpression(3))
    plusExpression.eval() shouldEqual 5
  }
}
