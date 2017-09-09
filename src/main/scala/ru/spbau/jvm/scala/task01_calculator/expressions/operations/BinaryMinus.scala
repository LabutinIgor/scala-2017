package ru.spbau.jvm.scala.task01_calculator.expressions.operations

import ru.spbau.jvm.scala.task01_calculator.expressions.Expression

class BinaryMinus(override val leftExpr: Expression, override val rightExpr: Expression) extends
  BinaryOperation(leftExpr, rightExpr) {

  override def apply(args: List[Double]): Double = {
    args.head - args(1)
  }
}
