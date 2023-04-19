package cl.uchile.dcc
package card

/** An abstract class representing a Card with a name and strength.
 *
 * @constructor Create a new Card with the given name and strength.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
abstract class AbstractCard(override val name: String, override var strength: Int) extends Card
