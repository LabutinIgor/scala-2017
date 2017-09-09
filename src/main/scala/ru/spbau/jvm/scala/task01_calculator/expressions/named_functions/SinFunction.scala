package ru.spbau.jvm.scala.task01_calculator.expressions.named_functions

import ru.spbau.jvm.scala.task01_calculator.expressions.Expression

class SinFunction(override val args: List[Expression]) extends NamedFunction(args) {
  override val name = "sin"

  override def apply(args: List[Double]): Double = {
    if (args.length != 1) throw new IllegalArgumentException()
    scala.math.sin(args.head)
  }
}
