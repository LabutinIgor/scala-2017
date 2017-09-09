package ru.spbau.jvm.scala.task01_calculator.expressions.named_functions

import ru.spbau.jvm.scala.task01_calculator.expressions.Expression

class PowFunction(override val args: List[Expression]) extends NamedFunction(args) {
  override val name = "pow"

  override def apply(args: List[Double]): Double = {
    if (args.length != 2) throw new IllegalArgumentException()
    scala.math.pow(args.head, args(1))
  }
}
