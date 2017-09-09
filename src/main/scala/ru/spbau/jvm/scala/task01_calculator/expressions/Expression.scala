package ru.spbau.jvm.scala.task01_calculator.expressions

trait Expression {
  def eval(): Double

  def apply(args: List[Double]): Double
}
