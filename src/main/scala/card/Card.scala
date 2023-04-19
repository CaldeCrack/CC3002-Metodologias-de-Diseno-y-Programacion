package cl.uchile.dcc
package card

/** A trait representing a Card.
 *
 * @constructor Create a new Card with the given name and strength.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
trait Card{
  /** The name of the Card. */
  val name: String
  /** The strength of the Card. */
  var strength: Int

  /** Adds 1 to the strength of the card */
  def addStrength(): Unit
  /** Duplicates the strength of the card */
  def dupStrength(): Unit
  /** Sets to 1 the strength of the card */
  def lowStrength(): Unit
  /** Resets to the original value of strength of the card */
  def resetStrength(): Unit
}