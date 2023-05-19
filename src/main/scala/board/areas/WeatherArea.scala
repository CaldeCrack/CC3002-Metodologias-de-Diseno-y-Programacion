package cl.uchile.dcc
package board.areas

import card.nonUnitCards.WeatherCard
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
class WeatherArea(var list: ListBuffer[WeatherCard] = ListBuffer()) {

}
