package cl.uchile.dcc
package card.nonUnitCards

import card.Card
import java.util.Objects

/** A WeatherCard that extends AbstractNonUnitCard.
 *
 * A WeatherCard is defined by its name.
 *
 * @param name The name of the card.
 *
 * @constructor Create a new WeatherCard with the given name.
 *
 * @example
 * {{{
 * val weatherCard = new weatherCard("card")
 * val name = weatherCard.name
 * println(s"The name of the card is $name")
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class WeatherCard(val name: String) extends Card with Equals{
  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val card = new WeatherCard("Card")
   * val card2 = new WeatherCard("Card2")
   * val _canEqual = card.canEqual(card2)
   * println(s"card can equal card2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      // Returns if its equal or not
      name == other.name
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[WeatherCard], name)
}