package cl.uchile.dcc
package cardTests

import card.unitCards.RangerCard
import munit.FunSuite
class RangerCardTests extends FunSuite {
  val name = "RangerCard"
  val strength = 5

  var card: RangerCard = _
  override def beforeEach(context: BeforeEach): Unit = card = new RangerCard(name, strength)

  test("equals") {
    val card2 = new RangerCard("RangerCard", 5)
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }

  test("A RangerCard has a name") {
    assertEquals(card.name, name)
  }

  test("A RangerCard has a strength (greater than 0)") {
    assertEquals(card.strength, strength)
    assert(card.strength > 0)
  }

  test("A RangerCard can add 1 to its strength") {
    card.addStrength()
    assertEquals(card.strength, 6)
    card.addStrength()
    card.addStrength()
    assertEquals(card.strength, 8)
  }

  test("A RangerCard can duplicate its strength") {
    card.dupStrength()
    assertEquals(card.strength, 10)
  }

  test("A RangerCard can set its strength to 1") {
    card.lowStrength()
    assertEquals(card.strength, 1)
  }

  test("A RangerCard can reset its strength to its original value") {
    card.addStrength()
    assertEquals(card.strength, 6)
    card.resetStrength()
    assertEquals(card.strength, 5)
  }
}
