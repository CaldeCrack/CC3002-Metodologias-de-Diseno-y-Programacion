package cl.uchile.dcc
package playerTests

import scala.collection.mutable.ListBuffer
import card.Card
import player.Player

import munit.FunSuite
class PlayerTests extends FunSuite {
  val name = "Player"

  var player: Player = _
  override def beforeEach(context: BeforeEach): Unit = {
    player = new Player(name, deck = ListBuffer())
  }
  test("equals") {
    val player2 = new Player("Player", deck = ListBuffer())
    assertEquals(player, player)
    assert(player.equals(player2))
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

  test("A Player initially has an empty hand (of max 10 cards)") {
    assertEquals(player.hand.length, 10)
    for (i <- 0 to 9) {
      assert(player.hand.lift(i).isEmpty)
    }
  }

  test("A Player can draw cards") {
    assert(player.hand.isEmpty)
    player.drawCard()
    assert(player.hand.nonEmpty)
    player.drawCard()
    player.drawCard()
    assert(player.hand.lift(2).isDefined)
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

  test("A Player initially has a deck of 25 cards") {
    assertEquals(player.deck.length, 25)
  }

  test("A Player's deck can decrease its amount of cards") {
    player.drawCard()
    assert(player.deck.lift(24).isEmpty)
    player.drawCard()
    player.drawCard()
    assert(player.deck.lift(22).isEmpty)
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
}