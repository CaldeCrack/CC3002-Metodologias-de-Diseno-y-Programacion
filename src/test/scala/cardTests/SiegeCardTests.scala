package cl.uchile.dcc
package cardTests

import card.unitCards.SiegeCard
import munit.FunSuite
class SiegeCardTests extends FunSuite {
  val name = "SiegeCard"
  val strength = 5

  var card: SiegeCard = _
  override def beforeEach(context: BeforeEach): Unit = card = new SiegeCard(name, strength)

  test("equals") {
    val card2 = new SiegeCard("SiegeCard", 5)
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }

  test("A SiegeCard has a name") {
    assertEquals(card.name, name)
  }

  test("A SiegeCard has a strength (greater than 0)") {
    assertEquals(card.strength, strength)
    assert(card.strength > 0)
  }

  test("A SiegeCard can add 1 to its strength") {
    card.addStrength()
    assertEquals(card.strength, 6)
    card.addStrength()
    card.addStrength()
    assertEquals(card.strength, 8)
  }

  test("A SiegeCard can duplicate its strength") {
    card.dupStrength()
    assertEquals(card.strength, 10)
  }

  test("A SiegeCard can set its strength to 1") {
    card.lowStrength()
    assertEquals(card.strength, 1)
  }

  test("A SiegeCard can reset its strength to its original value") {
    card.addStrength()
    assertEquals(card.strength, 6)
    card.resetStrength()
    assertEquals(card.strength, 5)
  }
}
