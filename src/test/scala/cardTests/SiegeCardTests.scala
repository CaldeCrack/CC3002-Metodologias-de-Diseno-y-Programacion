package cl.uchile.dcc
package cardTests

import card.SiegeCard
import munit.FunSuite
class SiegeCardTests extends FunSuite {
  val name = "SiegeCard"
  val strength = 6

  var card: SiegeCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new SiegeCard(name, strength)
  }

  test("equals") {
    val card2 = new SiegeCard("SiegeCard", 6)
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }
}
