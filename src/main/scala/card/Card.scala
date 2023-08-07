package cl.uchile.dcc
package card

import board.{Board, PlayerBoard}

/** A trait representing a Card.
 *
 * @constructor Creates a new Card with the given name.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
trait Card{
  /** The name of the Card. */
  val _name: String
  /** Add the card to the board. */
  def addCard(board: Board, playerBoard: PlayerBoard): Unit
}

/** A trait representing if a Card is capable of using its strength.
 *
 * @constructor Adds strength and its related methods.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
trait StrengthCapable{
  /** The strength of the Card. */
  private var _strength: Int = _
  /** Add 1 to the actual strength of the card */
  def addStrength(): Unit
  /** Duplicates the actual strength of the card */
  def dupStrength(): Unit
  /** Sets the strength of the card to 1 */
  def lowStrength(): Unit
  /** Resets the strength of the card to its original value */
  def resetStrength(): Unit
}