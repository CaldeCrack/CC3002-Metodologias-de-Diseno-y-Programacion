package cl.uchile.dcc
package cardTests

import cl.uchile.dcc.card.unitCards.MeleeUnitCard
import munit.FunSuite
class MeleeCardTests extends FunSuite {
  val name = "MeleeCard"
  val strength = 6

  var card: MeleeUnitCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new MeleeUnitCard(name, strength)
  }
  test("equals") {
    val card2 = new MeleeUnitCard("MeleeCard", 6)
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }
}