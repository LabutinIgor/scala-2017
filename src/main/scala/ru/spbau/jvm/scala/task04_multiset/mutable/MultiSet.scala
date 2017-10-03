package ru.spbau.jvm.scala.task04_multiset.mutable

import scala.collection.mutable

object MultiSet {
  def apply[T](seq: T*): MultiSet[T] = {
    val map: mutable.Map[T, Int] = mutable.Map.empty
    seq.foreach(x => map.update(x, map.getOrElse(x, 0) + 1))
    new MultiSet[T](map)
  }

  def unapplySeq[T](multiSet: MultiSet[T]): Option[Seq[T]] = {
    if (multiSet.isEmpty) {
      None
    } else {
      Some(multiSet.elementsMap.flatMap({ case (x, cnt) => Seq.fill(cnt)(x) }).toSeq)
    }
  }
}

class MultiSet[T](private val elementsMap: mutable.Map[T, Int] = mutable.Map.empty) {
  def add(x: T): Unit = {
    elementsMap.update(x, elementsMap.getOrElse(x, 0) + 1)
  }

  def isEmpty: Boolean = {
    elementsMap.isEmpty
  }

  def filter(func: T => Boolean): MultiSet[T] = {
    new MultiSet[T](elementsMap.filter({ case (x, _) => func(x) }))
  }

  def map[V](func: T => V): MultiSet[V] = {
    new MultiSet[V](elementsMap.map({ case (x, cnt) => (func(x), cnt) }))
  }

  def flatMap[B](func: T => Seq[B]): MultiSet[B] = {
    new MultiSet[B](elementsMap.flatMap({ case (x, cnt) => func(x).map(y => (y, cnt)) }))
  }

  def apply(x: T): Int = {
    elementsMap.getOrElse(x, 0)
  }

  def find(x: T): Option[T] = {
    elementsMap.get(x).map(_ => x)
  }

  def &(multiSet: MultiSet[T]): MultiSet[T] = {
    new MultiSet[T](elementsMap.map({ case (x, cnt) => (x, math.min(cnt, multiSet.elementsMap.getOrElse(x, 0))) })
      .filter({ case (x, cnt) => cnt > 0 }))
  }

  def |(multiSet: MultiSet[T]): MultiSet[T] = {
    val sumElementsMap = elementsMap.map({ case (x, cnt) => (x, cnt + multiSet.elementsMap.getOrElse(x, 0)) })
    multiSet.elementsMap.foreach({ case (x, cnt) => if (!elementsMap.contains(x)) {
      sumElementsMap.update(x, cnt)
    }
    })
    new MultiSet[T](sumElementsMap)
  }
}
