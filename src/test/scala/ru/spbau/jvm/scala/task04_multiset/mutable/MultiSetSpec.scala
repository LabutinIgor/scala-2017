package ru.spbau.jvm.scala.task04_multiset.mutable

import ru.spbau.jvm.scala.task04_multiset.UnitSpec

class MultiSetSpec extends UnitSpec {
  "A MultiSet" should "constructs by T* and find elements" in {
    val multiSet: MultiSet[Int] = MultiSet(1, 2, 4, 4)
    multiSet.isEmpty shouldEqual false
    multiSet(1) shouldEqual 1
    multiSet(2) shouldEqual 1
    multiSet(4) shouldEqual 2
    multiSet(3) shouldEqual 0
    multiSet.find(1) shouldEqual Some(1)
    multiSet.find(2) shouldEqual Some(2)
    multiSet.find(3) shouldEqual None
    multiSet.find(4) shouldEqual Some(4)
  }

  it should "add and find elements" in {
    val multiSet: MultiSet[Int] = MultiSet()
    multiSet.isEmpty shouldEqual true
    multiSet.add(1)
    multiSet.add(2)
    multiSet.add(4)
    multiSet.add(4)
    multiSet.isEmpty shouldEqual false
    multiSet(1) shouldEqual 1
    multiSet(2) shouldEqual 1
    multiSet(3) shouldEqual 0
    multiSet(4) shouldEqual 2
  }

  it should "filter elements" in {
    val multiSet: MultiSet[Int] = MultiSet(1, 2, 3, 4, 4, 5).filter(_ % 2 == 0)
    multiSet(1) shouldEqual 0
    multiSet(2) shouldEqual 1
    multiSet(3) shouldEqual 0
    multiSet(4) shouldEqual 2
    multiSet(5) shouldEqual 0
  }

  it should "map elements to Strings" in {
    val multiSet: MultiSet[Int] = MultiSet(1, 2, 3, 4, 4)
    val mappedMultiSet: MultiSet[String] = multiSet.map(_.toString())
    mappedMultiSet("1") shouldEqual 1
    mappedMultiSet("2") shouldEqual 1
    mappedMultiSet("3") shouldEqual 1
    mappedMultiSet("4") shouldEqual 2
  }

  it should "flatMap" in {
    val multiSet: MultiSet[Int] = MultiSet(1, 2, 4, 4).flatMap(x => Seq(x, 2 * x))
    multiSet(1) shouldEqual 1
    multiSet(2) shouldEqual 2
    multiSet(3) shouldEqual 0
    multiSet(4) shouldEqual 3
    multiSet(8) shouldEqual 2
  }

  it should "be iterated by for" in {
    val multiSet: MultiSet[Int] = MultiSet(1, 2, 4, 4)
    var cnt = 0
    var sumElems = 0
    for (x <- multiSet) {
      cnt += 1
      sumElems += x
    }
    cnt shouldEqual 4
    sumElems shouldEqual 11
  }

  it should "match" in {
    MultiSet(1, 2, 4, 4) match {
      case MultiSet(_, _, _, _) =>
      case _ => fail("not matched")
    }
  }

  it should "intersect sets" in {
    val multiSet1 = MultiSet(1, 6, 1, 2, 4)
    val multiSet2 = MultiSet(1, 1, 1, 3, 5, 6)
    val andMultiset = multiSet1 & multiSet2
    andMultiset(1) shouldEqual 2
    andMultiset(2) shouldEqual 0
    andMultiset(3) shouldEqual 0
    andMultiset(4) shouldEqual 0
    andMultiset(5) shouldEqual 0
    andMultiset(6) shouldEqual 1
  }

  it should "unite sets" in {
    val multiSet1 = MultiSet(1, 6, 1, 2, 4)
    val multiSet2 = MultiSet(1, 1, 1, 3, 5, 6)
    val orMultiset = multiSet1 | multiSet2
    orMultiset(1) shouldEqual 5
    orMultiset(2) shouldEqual 1
    orMultiset(3) shouldEqual 1
    orMultiset(4) shouldEqual 1
    orMultiset(5) shouldEqual 1
    orMultiset(6) shouldEqual 2
  }
}
