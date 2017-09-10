package ru.spbau.jvm.scala.task01_calculator.expressions.operations

import ru.spbau.jvm.scala.task01_calculator.UnitSpec
import ru.spbau.jvm.scala.task01_calculator.expressions.ConstExpression

class BinaryMulSpec extends UnitSpec {
  "A BinaryMul" should "Return 10*2=20" in {
    val mulExpression = new BinaryMul(new ConstExpression(10), new ConstExpression(2))
    mulExpression.eval() shouldEqual 20
  }
}
