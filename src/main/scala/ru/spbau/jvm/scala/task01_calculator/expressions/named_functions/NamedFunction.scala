package ru.spbau.jvm.scala.task01_calculator.expressions.named_functions

import ru.spbau.jvm.scala.task01_calculator.expressions.Expression

abstract class NamedFunction(val args: List[Expression]) extends Expression {

  override def eval(): Double = {
    apply(args.map(expr => expr.eval()))
  }
}
