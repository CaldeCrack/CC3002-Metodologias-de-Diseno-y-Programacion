package cl.uchile.dcc
package board

import card.Card
import board.areas.{MeleeArea, RangerArea, SiegeArea, WeatherArea}

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
class Board {
  /** Melee area of the board */
  var meleeArea: MeleeArea = new MeleeArea()
  /** Ranger area of the board */
  var rangerArea: RangerArea = new RangerArea()
  /** Siege area of the board */
  var siegeArea: SiegeArea = new SiegeArea()
  /** Weather area of the board */
  var weatherArea: WeatherArea = new WeatherArea()

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
}