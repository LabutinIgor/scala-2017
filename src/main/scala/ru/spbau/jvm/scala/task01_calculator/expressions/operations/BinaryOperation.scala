package ru.spbau.jvm.scala.task01_calculator.expressions.operations

import ru.spbau.jvm.scala.task01_calculator.expressions.Expression

abstract class BinaryOperation(val leftExpr: Expression, val rightExpr: Expression) extends Expression {
  override def eval(): Double = {
    apply(List(leftExpr.eval(), rightExpr.eval()))
  }
}
