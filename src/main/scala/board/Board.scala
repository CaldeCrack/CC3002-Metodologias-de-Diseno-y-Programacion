package cl.uchile.dcc
package board

import card.Card
import board.areas.{MeleeArea, RangerArea, SiegeArea, WeatherArea}
import java.util.Objects

/** A class representing a board.
 *
 * A player is defined by its name and deck.
 *
 * @constructor Creates a new board with its corresponding areas.
 *
 * @example
 * {{{
 * val board = new Board()
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class Board(var meleeArea: MeleeArea = new MeleeArea(), var rangerArea: RangerArea = new RangerArea(),
            var siegeArea: SiegeArea = new SiegeArea(), var weatherArea: WeatherArea = new WeatherArea()) extends Equals {

  /** Adds a card to its corresponding area in the board.
   *
   * @example
   * {{{
   * val card = new MeleeCard("meleeCard", 5)
   * val board = new Board()
   * board.addCard(card)
   * }}}
   */
  def addCard(card: Card): Unit = card.addCard(this)

  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val board = new Board()
   * val board2 = new Board()
   * val _canEqual = board.canEqual(board2)
   * println(s"board can equal board2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Board]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[Board]
      // Returns if its equal or not
      meleeArea == other.meleeArea && rangerArea == other.rangerArea &&
        siegeArea == other.siegeArea && weatherArea == other.weatherArea
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[Board], meleeArea, rangerArea, siegeArea, weatherArea)
}