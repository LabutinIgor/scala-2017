package ru.spbau.jvm.scala.task01_calculator.expressions

class ConstExpression(val value: Double) extends Expression {
  override val name = "const"

  override def eval(): Double = {
    apply(List())
  }

  override def apply(args: List[Double]): Double = {
    value
  }
}
