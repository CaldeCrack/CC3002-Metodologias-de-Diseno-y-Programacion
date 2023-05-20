package cl.uchile.dcc
package board.areas

import card.Card
import scala.collection.mutable.ListBuffer

/** A trait representing an Area.
 *
 * @constructor Creates a new Area with a list of cards.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
trait Area {
  /**  List of cards of the area */
  var list: ListBuffer[Card]
}