package cl.uchile.dcc
package cardTests

import card.MeleeCard
import munit.FunSuite
class MeleeCardTests extends FunSuite {
  val name = "MeleeCard"
  val strength = 6

  var card: MeleeCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new MeleeCard(name, strength)
  }
  test("equals") {
    val card2 = new MeleeCard("MeleeCard", 6)
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }
}