package ru.spbau.jvm.scala.task01_calculator.expressions.operations

import ru.spbau.jvm.scala.task01_calculator.UnitSpec
import ru.spbau.jvm.scala.task01_calculator.expressions.ConstExpression

class BinaryDivSpec extends UnitSpec {
  "A BinaryDiv" should "Return 10/2=5" in {
    val divExpression = new BinaryDiv(new ConstExpression(10), new ConstExpression(2))
    divExpression.eval() shouldEqual 5
  }
}
