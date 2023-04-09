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

  test("A Player initially has an empty hand (of max 10 cards)") {
    assertEquals(player.hand.length, 10)
    for (i <- 0 to 9) {
      assert(Option(player.hand(i)).isEmpty)
    }
  }

  test("A Player can draw cards") {
    assert(Option(player.hand(0)).isEmpty)
    player.drawCard()
    assert(Option(player.hand(0)).isDefined)
    player.drawCard()
    player.drawCard()
    assert(Option(player.hand(2)).isDefined)
  }

  test("A Player can't have more than 10 cards in hand") {
    for (i <- 0 to 9) {
      player.drawCard()
    }
    val lastOne: Option[Card] = Some(player.hand(9))
    assert(Option(player.hand(9)).isDefined)
    player.drawCard()
    assertEquals(player.hand(9), lastOne.get)
  }

  test("A Player initially has a deck of 25 cards") {
    assertEquals(player.deck.length, 25)
  }

  test("A Player's deck can decrease its amount of cards") {
    player.drawCard()
    assert(Option(player.deck(24)).isEmpty)
    player.drawCard()
    player.drawCard()
    assert(Option(player.deck(22)).isEmpty)
  }

  test("A Player can't draw cards if it has 10 in hand") {
    for (i <- 1 to 10) {
      player.drawCard()
    }
    assert(Option(player.deck(14)).isDefined)
    player.drawCard()
    assert(Option(player.deck(14)).isDefined)
  }
}