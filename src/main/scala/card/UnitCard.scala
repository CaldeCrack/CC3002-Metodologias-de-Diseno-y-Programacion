package cl.uchile.dcc
package card

import java.util.Objects

/** A UnitCard that extends AbstractCard and the trait Card.
 *
 * @constructor Create a new UnitCard with the given name and strength.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class UnitCard(name: String, strength: Int) extends AbstractCard(name, strength) with Equals {
  private val baseStrength: Int = strength

  def addStrength(): Unit = strength = strength+1
  def dupStrength(): Unit = strength = strength*2
  def lowStrength(): Unit = strength = 1
  def resetStrength(): Unit = strength = baseStrength

  override def canEqual(that: Any): Boolean = that.isInstanceOf[UnitCard]

  override def equals(that: Any): Boolean = {
    if(canEqual(that)) {
      val other = that.asInstanceOf[UnitCard]
      name == other.name && strength == other.strength
    } else false
  }

  override def hashCode: Int = {Objects.hash(classOf[UnitCard], name, strength)}
}