package cl.uchile.dcc
package card

import java.util.Objects

/** A MeleeCard that extends UnitCard and methods from the trait Card.
 *
 * @constructor Create a new MeleeCard with the given name and strength.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class MeleeCard(name: String, strength: Int) extends UnitCard(name, strength) with Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[MeleeCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[MeleeCard]
      name == other.name && strength == other.strength
    } else false
  }

  override def hashCode: Int = {
    Objects.hash(classOf[MeleeCard], name, strength)
  }
}