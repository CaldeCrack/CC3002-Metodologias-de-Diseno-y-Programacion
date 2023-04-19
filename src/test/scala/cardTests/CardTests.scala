package cl.uchile.dcc
package cardTests

import card.Card
import munit.FunSuite
class CardTests extends FunSuite {
  val name = "Card"
  val strength = 5

  var defaultCard: Card = _
  var card: Card = _
  override def beforeEach(context: BeforeEach): Unit = {
    defaultCard = new Card(name)
    card = new Card(name, strength)
  }

  test("equals") {
    val card2 = new Card("Card")
    val card3 = new Card("Card", 5)
    assertEquals(card, card)
    assert(defaultCard.equals(card2))
    assert(!defaultCard.equals(card3))
    assert(card.equals(card3))
  }

  test("A Card has a name") {
    assertEquals(defaultCard.name, name)
    assertEquals(card.name, name)
  }

  test("A Card has a strength") {
    assertEquals(defaultCard.strength, 0)
    assertEquals(card.strength, strength)
  }

  test("A Card can add 1 to its strength") {
    card.addStrength()
    assertEquals(card.strength, 6)
    card.addStrength()
    card.addStrength()
    assertEquals(card.strength, 8)
  }

  test("A Card can duplicate its strength") {
    card.dupStrength()
    assertEquals(card.strength, 10)
  }

  test("A Card can set its strength to 1") {
    card.lowStrength()
    assertEquals(card.strength, 1)
  }

  test("A Card can reset its strength to its original value") {
    card.addStrength()
    assertEquals(card.strength, 6)
    card.resetStrength()
    assertEquals(card.strength, 5)
  }
}