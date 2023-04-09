package cl.uchile.dcc
package cardTests

import munit.FunSuite
class CardTests extends Funsuite {
  val name = "Card"


  var card: Card = _

  override def beforeEach(context: BeforeEach): Unit = {
    card = new Card(name)
  }
  test("A Card has a name") {
    assertEquals(card.name, name)
  }
}