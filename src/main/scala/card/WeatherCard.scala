package cl.uchile.dcc
package card

import java.util.Objects

/** A WeatherCard that extends NonUnitCard and methods from the trait Card.
 *
 * @constructor Create a new WeatherCard with the given name and strength.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class WeatherCard(name: String, strength: Int) extends NonUnitCard(name, strength) {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      name == other.name && strength == other.strength
    } else false
  }

  override def hashCode: Int = {
    Objects.hash(classOf[WeatherCard], name, strength)
  }
}