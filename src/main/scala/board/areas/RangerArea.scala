package cl.uchile.dcc
package board.areas

import card.Card
import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A RangerArea that extends AbstractArea.
 *
 * A RangerArea is defined by its list of ranger cards.
 *
 * @param list contains a mutable list of ranger cards.
 *
 * @constructor Creates a new RangerArea with an empty list of ranger cards.
 *
 * @example
 * {{{
 * val rangerArea = new RangerArea()
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class RangerArea(list: ListBuffer[Card] = ListBuffer()) extends AbstractArea(list) with Equals {
  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val rangerArea = new RangerArea()
   * val rangerArea2 = new RangerArea()
   * val _canEqual = rangerArea.canEqual(rangerArea2)
   * println(s"rangerArea can equal rangerArea2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[RangerArea]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[RangerArea]
      // Returns if its equal or not
      list == other.list
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[RangerArea], list)
}