package ru.spbau.jvm.scala.task01_calculator.expressions

class Brackets(val expr: Expression) extends Expression {

  override def eval(): Double = {
    apply(List(expr.eval()))
  }

  override def apply(args: List[Double]): Double = {
    args.head
  }
}
