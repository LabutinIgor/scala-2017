package ru.spbau.jvm.scala.task01_calculator.expressions.operations

import ru.spbau.jvm.scala.task01_calculator.expressions.Expression

abstract class UnaryOperation(val expr: Expression) extends Expression {
  override def eval(): Double = {
    apply(List(expr.eval()))
  }
}
