package cl.uchile.dcc
package card.unitCards

import board.Board
import java.util.Objects

/** A MeleeCard that extends AbstractUnitCard.
 *
 * A MeleeCard is defined by its name and strength.
 *
 * @param name The name of the card.
 * @param strength The strength of the card.
 *
 * @constructor Creates a new MeleeCard with the given name and strength.
 *
 * @example
 * {{{
 * val meleeCard = new MeleeCard("card", 5)
 * val name = meleeCard.name
 * println(s"The name of the card is $name")
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class MeleeCard(name: String, strength: Int) extends AbstractUnitCard(name, strength) with Equals{

  /** Adds this card to its corresponding area in the board.
   *
   * @example
   * {{{
   * val card = new MeleeCard("meleeCard", 5)
   * val board = new Board()
   * card.addCard(board)
   * }}}
   */
  override def addCard(board: Board): Unit = board.meleeArea.list.addOne(this)
  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val card = new MeleeCard("Card", 5)
   * val card2 = new MeleeCard("Card2", 5)
   * val _canEqual = card.canEqual(card2)
   * println(s"card can equal card2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[MeleeCard]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[MeleeCard]
      // Returns if its equal or not
      name == other.name && strength == other.strength
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[MeleeCard], name, strength)
}