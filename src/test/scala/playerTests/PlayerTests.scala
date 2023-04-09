package cl.uchile.dcc
package playerTests

import munit.FunSuite
class PlayerTests extends Funsuite {
  val name = "Player"
  val hand: Array[Card] = Array[Card]()
  // val deck: Array[Card] = Array[Card]() create a deck by default

  var player: Player = _
  override def beforeEach(context: BeforeEach): Unit = {
    player = new Player(name)
  }
  test("A Player has a name") {
    assertEquals(player.name, name)
  }

  test("A Player initially has gems") {
    assertEquals(player.gems, 2)
  }

  test("A Player can lose its gems") {
    player.loseGems(1)
    assertEquals(player.gems, 1)
    player.loseGems(1)
    assertEquals(player.gems, 0)
  }

  test("A Player has a hand (of cards)") {
    assertEquals(player.hand, hand)
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
}