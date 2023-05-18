package cl.uchile.dcc
package cardTests

import cl.uchile.dcc.card.unitCards.SiegeUnitCard
import munit.FunSuite
class SiegeCardTests extends FunSuite {
  val name = "SiegeCard"
  val strength = 6

  var card: SiegeUnitCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new SiegeUnitCard(name, strength)
  }

  test("equals") {
    val card2 = new SiegeUnitCard("SiegeCard", 6)
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }
}
