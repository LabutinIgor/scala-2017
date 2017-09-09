package ru.spbau.jvm.scala.task01_calculator.expressions

trait Expression {
  val name: String

  def eval(): Double

  def apply(args: List[Double]): Double
}
