package cl.uchile.dcc
package board.areas

import card.Card
import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A MeleeArea that extends AbstractArea.
 *
 * A MeleeArea is defined by its list of melee cards.
 *
 * @param _list contains a mutable list of melee cards.
 *
 * @constructor Creates a new MeleeArea with an empty list of melee cards.
 *
 * @example
 * {{{
 * val meleeArea = new MeleeArea()
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class MeleeArea(private val _list: ListBuffer[Card] = ListBuffer()) extends AbstractArea(_list) with Equals {
  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val meleeArea = new MeleeArea()
   * val meleeArea2 = new MeleeArea()
   * val _canEqual = meleeArea.canEqual(meleeArea2)
   * println(s"meleeArea can equal meleeArea2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[MeleeArea]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[MeleeArea]
      // Returns if its equal or not
      list == other.list
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[MeleeArea], list)
}
