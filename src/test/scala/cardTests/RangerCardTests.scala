package cl.uchile.dcc
package cardTests

import cl.uchile.dcc.card.unitCards.RangerUnitCard
import munit.FunSuite
class RangerCardTests extends FunSuite {
  val name = "RangerCard"
  val strength = 6

  var card: RangerUnitCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new RangerUnitCard(name, strength)
  }

  test("equals") {
    val card2 = new RangerUnitCard("RangerCard", 6)
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }
}
