package cl.uchile.dcc
package cardTests

import card.UnitCard
import munit.FunSuite
class UnitCardTests extends FunSuite {
  val name = "UnitCard"
  val strength = 5

  var card: UnitCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new UnitCard(name, strength)
  }

  test("equals") {
    val card2 = new UnitCard("UnitCard", 5)
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }

  test("A UnitCard has a name") {
    assertEquals(card.name, name)
  }

  test("A UnitCard has a strength") {
    assertEquals(card.strength, strength)
  }

  test("A UnitCard can add 1 to its strength") {
    card.addStrength()
    assertEquals(card.strength, 6)
    card.addStrength()
    card.addStrength()
    assertEquals(card.strength, 8)
  }

  test("A UnitCard can duplicate its strength") {
    card.dupStrength()
    assertEquals(card.strength, 10)
  }

  test("A UnitCard can set its strength to 1") {
    card.lowStrength()
    assertEquals(card.strength, 1)
  }

  test("A UnitCard can reset its strength to its original value") {
    card.addStrength()
    assertEquals(card.strength, 6)
    card.resetStrength()
    assertEquals(card.strength, 5)
  }
}