package cl.uchile.dcc
package playerTests

import cl.uchile.dcc.card.Card
import cl.uchile.dcc.player.Player
import munit.FunSuite
class PlayerTests extends FunSuite {
  val name = "Player"

  var player: Player = _
  override def beforeEach(context: BeforeEach): Unit = {
    player = new Player(name, deck = new Array[Card](25))
  }
  test("A Player has a name") {
    assertEquals(player.name, name)
  }

  test("A Player initially has gems") {
    assertEquals(player.gems, 2)
  }

  test("A Player can lose gems") {
    player.loseGems(1)
    assertEquals(player.gems, 1)
    player.loseGems(1)
    assertEquals(player.gems, 0)
  }

  test("A Player initially has a hand (of max 10 cards)") {
    assertEquals(player.hand.length, 10)
  }

  test("A Player can draw cards") {
    player.drawCard()
    assertEquals(player.hand.length, 1)
    player.drawCard()
    player.drawCard()
    assertEquals(player.hand.length, 3)
  }

  test("A Player can't have more than 10 cards in hand") {
    for (i <- 1 to 10) {
      player.drawCard()
    }
    assertEquals(player.hand.length, 10)
    player.drawCard()
    assertEquals(player.hand.length, 10)
  }

  test("A Player initially has a deck of 25 cards") {
    assertEquals(player.deck.length, 25)
  }

  test("A Player's deck can decrease its amount of cards") {
    player.drawCard()
    assertEquals(player.deck.length, 24)
    player.drawCard()
    player.drawCard()
    assertEquals(player.deck.length, 22)
  }

  test("A Player can't draw cards if it has 10 in hand") {
    for (i <- 1 to 10) {
      player.drawCard()
    }
    assertEquals(player.deck.length, 15)
    player.drawCard()
    assertEquals(player.deck.length, 15)
  }
}