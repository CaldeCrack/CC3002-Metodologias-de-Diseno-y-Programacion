package cl.uchile.dcc
package boardTests

import board.Board
import munit.FunSuite
class BoardTests extends FunSuite {
  var board: Board = _

  override def beforeEach(context: BeforeEach): Unit = board = new Board()

  test("equals") {
    val card2 = new Board()
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }
}