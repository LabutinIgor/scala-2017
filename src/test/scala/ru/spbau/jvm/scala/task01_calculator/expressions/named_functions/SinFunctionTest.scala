package ru.spbau.jvm.scala.task01_calculator.expressions.named_functions

import ru.spbau.jvm.scala.task01_calculator.UnitSpec
import ru.spbau.jvm.scala.task01_calculator.expressions.{ConstExpression, Expression}

class SinFunctionTest extends UnitSpec {
  "A SinFunction" should "Return sin(0)=0" in {
    val powFunction = new SinFunction(List(new ConstExpression(0)))
    powFunction.eval() should be < 1e-8
  }

  "A SinFunction" should "throw IllegalArgumentException if it has not one argument" in {
    val powFunctionNoArgs = new SinFunction(List[Expression]())
    assertThrows[IllegalArgumentException] {
      powFunctionNoArgs.eval()
    }

    val powFunctionTwoArgs = new SinFunction(List(new ConstExpression(1), new ConstExpression(1)))
    assertThrows[IllegalArgumentException] {
      powFunctionTwoArgs.eval()
    }
  }

}
