package cl.uchile.dcc
package boardTests

import board.PlayerBoard
import munit.FunSuite

class PlayerBoardTests extends FunSuite {
  var playerBoard: PlayerBoard = _
  override def beforeEach(context: BeforeEach): Unit ={
    playerBoard = new PlayerBoard()
  }

  test("equals") {
    val playerBoard2 = new PlayerBoard()
    assert(playerBoard.canEqual(playerBoard2))
    assert(playerBoard.equals(playerBoard2))
    assert(!playerBoard.equals(null))
    assertEquals(playerBoard.##, playerBoard.##)
    assertEquals(playerBoard.##, playerBoard2.##)
  }
}