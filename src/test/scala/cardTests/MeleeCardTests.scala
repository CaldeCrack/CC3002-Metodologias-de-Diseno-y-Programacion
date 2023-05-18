package cl.uchile.dcc
package cardTests

import card.unitCards.MeleeCard
import munit.FunSuite
class MeleeCardTests extends FunSuite {
  val name = "MeleeCard"
  val strength = 5

  var card: MeleeCard = _
  override def beforeEach(context: BeforeEach): Unit = card = new MeleeCard(name, strength)

  test("equals") {
    val card2 = new MeleeCard("MeleeCard", 5)
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }

  test("A MeleeCard has a name") {
    assertEquals(card.name, name)
  }

  test("A MeleeCard has a strength (greater than 0)") {
    assertEquals(card.strength, strength)
    assert(card.strength > 0)
  }

  test("A MeleeCard can add 1 to its strength") {
    card.addStrength()
    assertEquals(card.strength, 6)
    card.addStrength()
    card.addStrength()
    assertEquals(card.strength, 8)
  }

  test("A MeleeCard can duplicate its strength") {
    card.dupStrength()
    assertEquals(card.strength, 10)
  }

  test("A MeleeCard can set its strength to 1") {
    card.lowStrength()
    assertEquals(card.strength, 1)
  }

  test("A MeleeCard can reset its strength to its original value") {
    card.addStrength()
    assertEquals(card.strength, 6)
    card.resetStrength()
    assertEquals(card.strength, 5)
  }
}