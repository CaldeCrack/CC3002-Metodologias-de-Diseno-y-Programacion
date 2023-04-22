package cl.uchile.dcc
package player

import scala.collection.mutable.ListBuffer
import scala.util.Random
import java.util.Objects
import card.Card

/** A class representing a Player.
 *
 * @constructor Creates a new Player with the specified name and deck of cards.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class Player(val name: String, var deck: ListBuffer[Card]) extends Equals {
  var gems: Int = 2
  var hand: ListBuffer[Card] = ListBuffer()
  private var maxHand: Boolean = false
  private var emptyDeck: Boolean = false
  private var handAmount: Int = 0
  private var curDeck: Int = 24

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Player]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Player]
      name == other.name && deck == other.deck
    } else false
  }

  override def hashCode: Int = {Objects.hash(classOf[Player], name, deck)}

  def loseGems(): Unit = gems -= 1

  def drawCard(): Unit = {
    if (!maxHand) {
      hand.addOne(deck.last)
      handAmount += 1
      deck.remove(curDeck)
      curDeck -= 1
    }
    if (handAmount == 10) {
      maxHand = true
    }
  }

  def shuffleDeck(): Unit = {
    Random.shuffle(deck)
  }
}