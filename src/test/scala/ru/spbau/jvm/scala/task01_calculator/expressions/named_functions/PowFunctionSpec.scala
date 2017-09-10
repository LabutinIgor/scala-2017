package ru.spbau.jvm.scala.task01_calculator.expressions.named_functions

import ru.spbau.jvm.scala.task01_calculator.UnitSpec
import ru.spbau.jvm.scala.task01_calculator.expressions.ConstExpression

class PowFunctionSpec extends UnitSpec {
  "A PowFunction" should "Return 2^10=1024" in {
    val powFunction = new PowFunction(List(new ConstExpression(2), new ConstExpression(10)))
    powFunction.eval() shouldEqual 1024
  }

}
