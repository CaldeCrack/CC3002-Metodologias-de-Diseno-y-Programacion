package cl.uchile.dcc
package board

import board.areas.{MeleeArea, RangerArea, SiegeArea}
import java.util.Objects

/** A class representing a player board.
 *
 * A player board is defined by its three areas.
 *
 * @constructor Creates a new player board with its corresponding areas.
 *
 * @example
 * {{{
 * val playerBoard = new PlayerBoard()
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class PlayerBoard(val _meleeArea: MeleeArea = new MeleeArea(),
                  val _rangerArea: RangerArea = new RangerArea(),
                  val _siegeArea: SiegeArea = new SiegeArea()) extends Equals {
  /** Getter for the parameter _meleeArea. */
  def meleeArea: MeleeArea = _meleeArea

  /** Getter for the parameter _meleeArea. */
  def rangerArea: RangerArea = _rangerArea

  /** Getter for the parameter _meleeArea. */
  def siegeArea: SiegeArea = _siegeArea

  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val playerBoard1 = new PlayerBoard()
   * val playerBoard2 = new PlayerBoard()
   * val _canEqual = playerBoard1.canEqual(playerBoard2)
   * println(s"playerBoard1 can equal playerBoard2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[PlayerBoard]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[PlayerBoard]
      // Returns if its equal or not
      meleeArea == other.meleeArea && rangerArea == other.rangerArea &&
        siegeArea == other.siegeArea
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[PlayerBoard], meleeArea, rangerArea, siegeArea)
}