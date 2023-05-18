package cl.uchile.dcc
package playerTests

import scala.collection.mutable.ListBuffer
import card.Card
import player.Player
import cl.uchile.dcc.card.nonUnitCards.WeatherCard
import cl.uchile.dcc.card.unitCards.{MeleeUnitCard, RangerUnitCard, SiegeUnitCard}

import munit.FunSuite
class PlayerTests extends FunSuite {
  val name = "Player"
  val card0 = new MeleeUnitCard("Melee0", 2)
  val card1 = new MeleeUnitCard("Melee1", 3)
  val card2 = new MeleeUnitCard("Melee2", 4)
  val card3 = new MeleeUnitCard("Melee3", 5)
  val card4 = new MeleeUnitCard("Melee4", 6)
  val card5 = new MeleeUnitCard("Melee5", 7)
  val card6 = new RangerUnitCard("Ranger0", 2)
  val card7 = new RangerUnitCard("Ranger1", 3)
  val card8 = new RangerUnitCard("Ranger2", 4)
  val card9 = new RangerUnitCard("Ranger3", 5)
  val card10 = new RangerUnitCard("Ranger4", 6)
  val card11 = new RangerUnitCard("Ranger5", 7)
  val card12 = new SiegeUnitCard("Siege0", 2)
  val card13 = new SiegeUnitCard("Siege1", 3)
  val card14 = new SiegeUnitCard("Siege2", 4)
  val card15 = new SiegeUnitCard("Siege3", 5)
  val card16 = new SiegeUnitCard("Siege4", 6)
  val card17 = new SiegeUnitCard("Siege5", 7)
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
    val commonEle = player.deck.intersect(_deck)
    assert(_deck!=commonEle)
  }
}