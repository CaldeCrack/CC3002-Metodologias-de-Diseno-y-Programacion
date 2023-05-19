package cl.uchile.dcc
package board.areas

import card.nonUnitCards.WeatherCard
import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A WeatherArea that extends AbstractArea.
 *
 * A WeatherArea is defined by its list of weather cards.
 *
 * @param list contains a mutable list of weather cards.
 *
 * @constructor Creates a new RangerArea with an empty list of weather cards.
 *
 * @example
 * {{{
 * val weatherArea = new WeatherArea()
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class WeatherArea(var list: ListBuffer[WeatherCard] = ListBuffer()) extends Equals {
  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val weatherArea = new WeatherArea()
   * val weatherArea2 = new WeatherArea()
   * val _canEqual = weatherArea.canEqual(weatherArea2)
   * println(s"weatherArea can equal weatherArea2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherArea]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherArea]
      // Returns if its equal or not
      list == other.list
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[MeleeArea], list)
}
