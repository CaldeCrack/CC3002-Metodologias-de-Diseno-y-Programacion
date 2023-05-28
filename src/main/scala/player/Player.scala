package cl.uchile.dcc
package player

import card.Card
import board.{Board, PlayerBoard}
import java.util.Objects
import scala.collection.mutable.ListBuffer
import scala.util.Random

/** A class representing a player.
 *
 * A player is defined by its name, deck and player board.
 *
 * @param name The name of the player.
 * @param _deck The deck of the player.
 * @param _playerBoard The 3 areas of the player.
 *
 * @constructor Creates a new player with the specified name and deck, and an empty player board.
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
class Player(val name: String, private var _deck: ListBuffer[Card], private val _playerBoard: PlayerBoard = new PlayerBoard()) extends Equals {
  /** The "lives" of the player */
  private var _gems: Int = 2
  /** The hand of the player (initially empty) */
  private val _hand: ListBuffer[Card] = ListBuffer()
  /** Boolean that states if the player has its hand full of cards (max 10) */
  private var maxHand: Boolean = false
  /** Current amount of cards in the hand */
  private var handAmount: Int = 0
  /** Upper card in the pile of cards of the deck */
  private var curDeck: Int = 24

  /** Getter for the parameter _gems. */
  def gems: Int = _gems

  /** Getter for the parameter _hand. */
  def hand: List[Card] = _hand.toList

  /** Getter for the parameter _deck. */
  def deck: List[Card] = _deck.toList

  /** Getter for the parameter _playerBoard. */
  def playerBoard: PlayerBoard = _playerBoard

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

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[Player]
      // Returns if its equal or not
      name == other.name && deck == other.deck
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[Player], name, deck)

  /** Reduces the amount of gems the player has.
   *
   * In this project gems represents the remaining lives of the player.
   *
   * @example
   * {{{
   * val deck= ListBuffer(...)
   * val player = new Player("Andres", deck)
   * player.loseGems()
   * var gems = player.gems
   * println(s"player remaining lives: $gems")
   * }}}
   */
  def loseGems(): Unit = if(gems>0) _gems -= 1

  /** player draws a card from its deck to his hand.
   *
   * @example
   * {{{
   * val deck= ListBuffer(...)
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
      _hand.addOne(deck.last)
      handAmount += 1
      // Removes this card from the deck
      _deck.remove(curDeck)
      curDeck -= 1
    }
    // If hand is full change state of [maxHand] to true
    if (handAmount == 10) maxHand = true
  }

  /** Shuffles the deck of the player.
   *
   * @example
   * {{{
   * val deck= ListBuffer(...)
   * val player = new Player("Andres", deck)
   * player.shuffleDeck()
   * }}}
   */
  def shuffleDeck(): Unit = _deck = Random.shuffle(_deck)

  /** Plays a card onto the board.
   *
   * @example
   * {{{
   * val deck1 = ListBuffer(...)
   * val deck2 = ListBuffer(...)
   * val player1 = new Player("Andres", deck1)
   * val player2 = new Player("Bot", deck2)
   * val board = new Board(player1, player2)
   * player1.playCard(board, player1.hand.head)
   * }}}
   */
  def playCard(board: Board, card: Card): Unit = {
    // Plays a card of the hand
    card.addCard(board, this.playerBoard)
    // Removes this card from the deck
    handAmount -= 1
    _hand.remove(_hand.indexOf(card))
    // After this maxHand will always be false
    maxHand = false
  }
}