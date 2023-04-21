package cl.uchile.dcc
package card

import java.util.Objects

/** A NonUnitCard that extends AbstractCard and the trait Card.
 *
 * @constructor Create a new NonUnitCard with the given name and strength.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class NonUnitCard(name: String) extends AbstractCard(name, 0) with Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[NonUnitCard]

  override def equals(that: Any): Boolean = {
    if(canEqual(that)) {
      val other = that.asInstanceOf[NonUnitCard]
      name == other.name && strength == other.strength
    } else false
  }

  override def hashCode: Int = {Objects.hash(classOf[NonUnitCard], name, strength)}
}