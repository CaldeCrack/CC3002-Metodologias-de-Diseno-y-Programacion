package cl.uchile.dcc
package boardTests

import board.Board
import player.Player
import card.Card
import card.unitCards.{MeleeCard, RangerCard, SiegeCard}
import card.nonUnitCards.WeatherCard
import munit.FunSuite
import scala.collection.mutable.ListBuffer

class BoardTests extends FunSuite {
  var board: Board = _
  val card0 = new MeleeCard("Melee0", 2)
  val card1 = new MeleeCard("Melee1", 3)
  val card2 = new MeleeCard("Melee2", 4)
  val card3 = new MeleeCard("Melee3", 5)
  val card4 = new MeleeCard("Melee4", 6)
  val card5 = new MeleeCard("Melee5", 7)
  val card6 = new RangerCard("Ranger0", 2)
  val card7 = new RangerCard("Ranger1", 3)
  val card8 = new RangerCard("Ranger2", 4)
  val card9 = new RangerCard("Ranger3", 5)
  val card10 = new RangerCard("Ranger4", 6)
  val card11 = new RangerCard("Ranger5", 7)
  val card12 = new SiegeCard("Siege0", 2)
  val card13 = new SiegeCard("Siege1", 3)
  val card14 = new SiegeCard("Siege2", 4)
  val card15 = new SiegeCard("Siege3", 5)
  val card16 = new SiegeCard("Siege4", 6)
  val card17 = new SiegeCard("Siege5", 7)
  val card18 = new WeatherCard("Weather0")
  val card19 = new WeatherCard("Weather2")
  val card20 = new WeatherCard("Weather4")
  val card21 = new WeatherCard("Weather6")
  val card22 = new WeatherCard("Weather8")
  val card23 = new WeatherCard("Weather10")
  val card24 = new WeatherCard("Weather12")
  val _deck: ListBuffer[Card] = ListBuffer(card0, card1, card2, card3, card4, card5, card6, card7,
    card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19,
    card20, card21, card22, card23, card24)
  var player1: Player = _
  var player2: Player = _

  override def beforeEach(context: BeforeEach): Unit = {
    val deck: ListBuffer[Card] = ListBuffer(card0, card1, card2, card3, card4, card5, card6, card7,
      card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19,
      card20, card21, card22, card23, card24)
    player1 = new Player("Andres", deck)
    player2 = new Player("Bot", deck)
    board = new Board(player1 = player1, player2 = player2)
  }

  test("equals") {
    val board2 = new Board(player1 = player1, player2 = player2)
    assert(board.canEqual(board2))
    assert(board.equals(board2))
    assert(!board.equals(null))
    assertEquals(board.##, board.##)
    assertEquals(board.##, board2.##)
  }

  test("Weather area can only have 1 card and replaces the previous one"){
    player1.drawCard()
    val playerCard1 = player1.hand.head
    assertEquals(board.weatherArea.list.length, 0)
    player1.playCard(board, player1.hand.head)
    assertEquals(board.weatherArea.list.length, 1)
    assertEquals(board.weatherArea.list.head, playerCard1)
    player1.drawCard()
    val playerCard2 = player1.hand.head
    player1.playCard(board, player1.hand.head)
    assertEquals(board.weatherArea.list.length, 1)
    assertEquals(board.weatherArea.list.head, playerCard2)
    assert(playerCard1 != playerCard2)
  }
}