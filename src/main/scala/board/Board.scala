package cl.uchile.dcc
package board

import board.areas.WeatherArea
import player.Player
import java.util.Objects

/** A class representing a board.
 *
 * A board is defined by players and the weather area.
 *
 * @constructor Creates a new board with its corresponding components.
 *
 * @example
 * {{{
 * val deck1 = ListBuffer(...)
 * val deck2 = ListBuffer(...)
 * val player1 = new Player("Andres", deck1)
 * val player2 = new Player("Bot", deck2)
 * val board = new Board(player1, player2)
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class Board(val player1: Player, val player2: Player, val weatherArea: WeatherArea = new WeatherArea()) extends Equals {
  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val deck1 = ListBuffer(...)
   * val deck2 = ListBuffer(...)
   * val player1 = new Player("Andres", deck1)
   * val player2 = new Player("Bot", deck2)
   * val board1 = new Board(player1, player2)
   * val board2 = new Board(player2, player1)
   * val _canEqual = board1.canEqual(board2)
   * println(s"board1 can equal board2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Board]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[Board]
      // Returns if its equal or not
      weatherArea == other.weatherArea && player1 == other.player1 && player2 == other.player2
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[PlayerBoard], weatherArea, player1, player2)
}
