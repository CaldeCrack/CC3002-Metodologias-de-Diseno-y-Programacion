package cl.uchile.dcc
package cardTests

import card.SiegeCard
import munit.FunSuite
class SiegeCardTests extends FunSuite {
  val name = "SiegeCard"
  val strength = 8

  var card: SiegeCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new SiegeCard(name, strength)
  }

  test("equals") {
    val card2 = new SiegeCard("SiegeCard", 8)
    assertEquals(card, card)
    assertEquals(card, card2)
  }
}
