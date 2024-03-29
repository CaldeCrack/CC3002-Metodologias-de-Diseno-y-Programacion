package cl.uchile.dcc
package card.unitCards

import board.{Board, PlayerBoard}
import java.util.Objects

/** A SiegeCard that extends AbstractUnitCard.
 *
 * A SiegeCard is defined by its name and strength.
 *
 * @param name The name of the card.
 * @param strength The strength of the card.
 *
 * @constructor Creates a new SiegeCard with the given name and strength.
 *
 * @example
 * {{{
 * val siegeCard = new SiegeCard("card", 5)
 * val name = siegeCard.name
 * println(s"The name of the card is $name")
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class SiegeCard(name: String, strength: Int) extends AbstractUnitCard(name, strength) with Equals{
  /** Adds this card to its corresponding area in the board.
   *
   * @example
   * {{{
   * val card1 = new SiegeCard("SiegeCard")
   * val deck1 = ListBuffer(card1, ...)
   * val deck2 = ListBuffer(card1, ...)
   * val player1 = new Player("Andres", deck1)
   * val player2 = new Player("Bot", deck2)
   * val board = new Board(player1, player2)
   * card1.addCard(board, player1.playerBoard)
   * }}}
   */
  override def addCard(board: Board, playerBoard: PlayerBoard): Unit = playerBoard.siegeArea.addCard(this)

  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val card = new SiegeCard("Card", 5)
   * val card2 = new SiegeCard("Card2", 5)
   * val _canEqual = card.canEqual(card2)
   * println(s"card can equal card2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeCard]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[SiegeCard]
      // Returns if its equal or not
      name == other.name && strength == other.strength
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[SiegeCard], name, strength)
}