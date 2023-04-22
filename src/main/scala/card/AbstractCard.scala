package cl.uchile.dcc
package card

/** An abstract class representing a Card with a name and strength.
 *
 * @constructor Create a new Card with the given name and strength.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
abstract class AbstractCard(val name: String, var _strength: Int) extends Card{
  def strength: Int = _strength
  def strength_=(newStrength: Int): Unit = _strength = newStrength
}
