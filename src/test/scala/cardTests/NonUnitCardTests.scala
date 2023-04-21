package cl.uchile.dcc
package cardTests

import card.NonUnitCard
import munit.FunSuite
class NonUnitCardTests extends FunSuite {
  val name = "NonUnitCard"

  var card: NonUnitCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new NonUnitCard(name)
  }

  test("equals") {
    val card2 = new NonUnitCard("NonUnitCard")
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }

  test("A NonUnitCard has a name") {
    assertEquals(card.name, name)
  }

  test("A Card has a strength equal to 0") {
    assertEquals(card.strength, 0)
  }
}