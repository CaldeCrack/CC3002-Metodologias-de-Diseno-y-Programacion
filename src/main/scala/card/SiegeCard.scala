package cl.uchile.dcc
package card

import java.util.Objects

/** A SiegeCard that extends UnitCard and methods from the trait Card.
 *
 * @constructor Create a new SiegeCard with the given name and strength.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class SiegeCard(name: String, strength: Int) extends UnitCard(name, strength){
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[SiegeCard]
      name == other.name && strength == other.strength
    } else false
  }

  override def hashCode: Int = {
    Objects.hash(classOf[SiegeCard], name, strength)
  }
}