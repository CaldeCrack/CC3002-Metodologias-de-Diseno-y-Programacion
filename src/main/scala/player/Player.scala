package cl.uchile.dcc
package player

import scala.collection.mutable.ListBuffer
import scala.util.Random
import java.util.Objects
import card.Card

/** A class representing a player.
 *
 * A player is defined by its name and deck.
 *
 * @param name The name of the player.
 * @param deck The deck of the player.
 *
 * @constructor Creates a new player with the specified name and deck.
 *
 * @example
 * {{{
 * val deck= ListBuffer(...)
 * val player = new Player("Andres", deck)
 * val name = player.name
 * println(s"The name of the player is $name")
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class Player(val name: String, var deck: ListBuffer[Card]) extends Equals {
  /** The "lives" of the player */
  var gems: Int = 2
  /** The hand of the player (initially empty) */
  var hand: ListBuffer[Card] = ListBuffer()
  /** Boolean that states if the player has its hand full of cards (max 10) */
  private var maxHand: Boolean = false
  /** Current amount of cards in the hand */
  private var handAmount: Int = 0
  /** Upper card in the pile of cards of the deck */
  private var curDeck: Int = 24

  /** Returns if the parameter can equals this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val deck= ListBuffer(...)
   * val player = new Player("Andres", deck)
   * val player2 = new Player("Calderon", deck)
   * val _canEqual = player.canEqual(player2)
   * println(s"player can equal player2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Player]

  /** Returns if the parameter equals this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If is equal to this object.
   * @example
   * {{{
   * val deck= ListBuffer(...)
   * val player = new Player("Andres", deck)
   * val player2 = new Player("Calderon", deck)
   * val _equals = player.equals(player2)
   * println(s"player equals player2 is $_equals")
   * }}}
   */
  override def equals(that: Any): Boolean = {
    // If that can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[Player]
      // Returns if its equal or not
      name == other.name && deck == other.deck
    } else false
  }

  /** Generates a hash code for this object.
   *
   * A hash code is a unique number that represents an object, its particularity is that this value will
   * always be the same if the object has the same parameters, so it can be used to compare objects.
   *
   * @return An integer.
   * @example
   * {{{
   * val player = new Player("Andres", deck)
   * val hashCodePlayer = player.##
   * println(s"The hash code of player is $hashCodePlayer")
   * }}}
   */
  override def hashCode: Int = {Objects.hash(classOf[Player], name, deck)}

  /** Reduces the amount of gems the player has.
   *
   * In this project gems represents the remaining lives of the player.
   *
   * @example
   * {{{
   * val player = new Player("Andres", deck)
   * player.loseGems()
   * var gems = player.gems
   * println(s"player remaining lives: $gems")
   * }}}
   */
  def loseGems(): Unit = gems -= 1

  /** Player draws a card from its deck to his hand.
   *
   * @example
   * {{{
   * val player = new Player("Andres", deck)
   * player.drawCard()
   * var handAmount = player.hand.length
   * println(s"player's hand cards: $handAmount")
   * }}}
   */
  def drawCard(): Unit = {
    // If hand is not full then draw a card
    if (!maxHand) {
      // Adds upper card in the deck to the hand
      hand.addOne(deck.last)
      handAmount += 1
      // Removes this card from the deck
      deck.remove(curDeck)
      curDeck -= 1
    }
    // If hand is full change state of maxHand to true
    if (handAmount == 10) maxHand = true
  }

  /** Shuffles the deck of the player.
   *
   * @example
   * {{{
   * val player = new Player("Andres", deck)
   * player.shuffleDeck()
   * }}}
   */
  def shuffleDeck(): Unit = Random.shuffle(deck)
}