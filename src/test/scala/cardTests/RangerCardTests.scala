package cl.uchile.dcc
package cardTests

import card.RangerCard
import munit.FunSuite
class RangerCardTests extends FunSuite {
  val name = "RangerCard"
  val strength = 6

  var card: RangerCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new RangerCard(name, strength)
  }

  test("equals") {
    val card2 = new RangerCard("RangerCard", 6)
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }
}
