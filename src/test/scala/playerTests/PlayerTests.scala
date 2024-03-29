package cl.uchile.dcc
package playerTests

import card.Card
import card.nonUnitCards.WeatherCard
import card.unitCards.{MeleeCard, RangerCard, SiegeCard}
import player.Player
import board.Board
import munit.FunSuite
import scala.collection.mutable.ListBuffer
class PlayerTests extends FunSuite {
  val name = "Player"
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

  var player: Player = _
  override def beforeEach(context: BeforeEach): Unit = {
    val deck: ListBuffer[Card] = ListBuffer(card0, card1, card2, card3, card4, card5, card6, card7,
      card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19,
      card20, card21, card22, card23, card24)
    player = new Player(name, deck)
  }

  test("equals") {
    val player2 = new Player("Player", _deck)
    assert(player.canEqual(player2))
    assert(player.equals(player2))
    assert(!player.equals(null))
    assertEquals(player.##, player.##)
    assertEquals(player.##, player2.##)
  }

  test("A Player has a name") {
    assertEquals(player.name, name)
  }

  test("A Player initially has gems") {
    assertEquals(player.gems, 2)
  }

  test("A Player can lose gems") {
    player.loseGems()
    assertEquals(player.gems, 1)
    player.loseGems()
    assertEquals(player.gems, 0)
  }

  test("A Player can't have negative gems"){
    assertEquals(player.gems, 2)
    player.loseGems()
    player.loseGems()
    player.loseGems()
    assertEquals(player.gems, 0)
  }

  test("A Player initially has a deck of 25 cards") {
    assertEquals(player.deck.length, 25)
  }

  test("A Player's deck can decrease its amount of cards") {
    assert(player.deck.lift(24).isDefined)
    player.drawCard()
    assert(player.deck.lift(24).isEmpty)
    player.drawCard()
    player.drawCard()
    assert(player.deck.lift(22).isEmpty)
  }

  test("A Player initially has an empty hand") {
    assert(player.hand.isEmpty)
  }

  test("A Player can draw cards") {
    assert(player.hand.isEmpty)
    player.drawCard()
    assert(player.hand.nonEmpty)
    player.drawCard()
    player.drawCard()
    assert(player.hand.lift(2).isDefined)
  }

  test("A Player can't draw cards if it has 10 in hand") {
    for (_ <- 0 to 9) {
      player.drawCard()
    }
    assertEquals(player.hand.length, 10)
    assert(player.deck.lift(14).isDefined)
    player.drawCard()
    assert(player.deck.lift(14).isDefined)
  }

  test("A Player can't have more than 10 cards in hand") {
    for (_ <- 0 to 9) {
      player.drawCard()
    }
    val lastOne: Option[Card] = player.hand.lift(9)
    assert(player.hand.lift(9).isDefined)
    player.drawCard()
    assertEquals(player.hand.lift(9), lastOne)
    assert(player.hand.lift(10).isEmpty)
  }

  test("A Player can shuffle its deck") {
    player.shuffleDeck()
    assert(_deck!=player.deck)
  }

  test("A Player can play a (weather or unit) card from its hand"){
    val deck2: ListBuffer[Card] = ListBuffer(card0, card1, card2, card3, card4, card5, card6, card7,
      card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19,
      card20, card21, card22, card23, card17)
    val player2 = new Player(name, deck2)
    val board = new Board(player, player2)
    player.drawCard()
    assertEquals(player.hand.length, 1)
    player.playCard(board, player.hand.head)
    assertEquals(board.weatherArea.list.length, 1)
    assertEquals(player.hand.length, 0)
    player2.drawCard()
    player2.playCard(board, player2.hand.head)
    assertEquals(player2.playerBoard.siegeArea.list.length, 1)
  }

  test("A Player can play any card in its hand (not only the one at the top of the hand)"){
    val deck2: ListBuffer[Card] = ListBuffer(card0, card1, card2, card3, card4, card5, card6, card7,
      card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19,
      card20, card5, card11, card17, card24)
    val player2 = new Player(name, deck2)
    val board = new Board(player, player2)
    for(i <- 0 to 9){
      player2.drawCard()
    }
    player2.playCard(board, player2.hand(3))
    assertEquals(player2.playerBoard.meleeArea.list.length, 1)
    player2.playCard(board, player2.hand(2))
    assertEquals(player2.playerBoard.rangerArea.list.length, 1)
  }
}