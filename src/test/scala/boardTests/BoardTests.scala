package cl.uchile.dcc
package boardTests

import board.Board

import card.unitCards.{MeleeCard, RangerCard, SiegeCard}
import card.nonUnitCards.WeatherCard
import munit.FunSuite
class BoardTests extends FunSuite {
  var board: Board = _

  override def beforeEach(context: BeforeEach): Unit = board = new Board()

  test("equals") {
    val board2 = new Board()
    assert(board.canEqual(board2))
    assert(board.equals(board2))
    assert(!board.equals(null))
    assertEquals(board.##, board.##)
    assertEquals(board.##, board2.##)
  }

  test("Can add cards to the board"){
    val card = new MeleeCard("melee", 5)
    val card2 = new SiegeCard("siege", 5)
    val card3 = new WeatherCard("weather")
    board.addCard(card)
    board.addCard(card2)
    board.addCard(card3)
    board.addCard(card3)
    assertEquals(board.meleeArea.list.length, 1)
    assertEquals(board.rangerArea.list.length, 0)
    assertEquals(board.siegeArea.list.length, 1)
    assertEquals(board.weatherArea.list.length, 2)
  }
}