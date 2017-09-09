package ru.spbau.jvm.scala.task01_calculator.expressions.operations

import ru.spbau.jvm.scala.task01_calculator.expressions.Expression

class UnaryMinus(override val expr: Expression) extends UnaryOperation(expr) {

  override def apply(args: List[Double]): Double = {
    -args.head
  }
}
