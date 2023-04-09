package cl.uchile.dcc
package cardTests

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
}