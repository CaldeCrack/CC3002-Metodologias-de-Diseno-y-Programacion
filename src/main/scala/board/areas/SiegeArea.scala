package cl.uchile.dcc
package board.areas

import card.unitCards.SiegeCard
import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A SiegeArea that extends AbstractArea.
 *
 * A SiegeArea is defined by its list of siege cards.
 *
 * @param list contains a mutable list of siege cards.
 *
 * @constructor Creates a new SiegeArea with an empty list of siege cards.
 *
 * @example
 * {{{
 * val siegeArea = new SiegeArea()
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class SiegeArea(var list: ListBuffer[SiegeCard] = ListBuffer()) extends Equals {
  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val siegeArea = new SiegeArea()
   * val siegeArea2 = new SiegeArea()
   * val _canEqual = siegeArea.canEqual(siegeArea2)
   * println(s"siegeArea can equal siegeArea2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeArea]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[SiegeArea]
      // Returns if its equal or not
      list == other.list
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[SiegeArea], list)
}