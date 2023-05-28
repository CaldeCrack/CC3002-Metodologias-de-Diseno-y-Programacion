package cl.uchile.dcc
package card.nonUnitCards

import card.Card
import board.{Board, PlayerBoard}
import java.util.Objects

/** A WeatherCard that extends AbstractNonUnitCard.
 *
 * A WeatherCard is defined by its name.
 *
 * @param _name The name of the card.
 *
 * @constructor Creates a new WeatherCard with the given name.
 *
 * @example
 * {{{
 * val weatherCard = new weatherCard("card")
 * val name = weatherCard.name
 * println(s"The name of the card is $name")
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class WeatherCard(val _name: String) extends Card with Equals{
  /** Getter for the parameter _name. */
  def name: String = _name

  /** Adds this card to its corresponding area in the board.
   *
   * @example
   * {{{
   * val card1 = new WeatherCard("WeatherCard")
   * val deck1 = ListBuffer(card1, ...)
   * val deck2 = ListBuffer(card1, ...)
   * val player1 = new Player("Andres", deck1)
   * val player2 = new Player("Bot", deck2)
   * val board = new Board(player1, player2)
   * card1.addCard(board, player1.playerBoard)
   * }}}
   */
  override def addCard(board: Board, playerBoard: PlayerBoard): Unit = {
    if(board.weatherArea.list.isEmpty){
      board.weatherArea.list.addOne(this)
    }
    else {
      board.weatherArea.list.clear()
      board.weatherArea.list.addOne(this)
    }
  }

  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val card = new WeatherCard("Card")
   * val card2 = new WeatherCard("Card2")
   * val _canEqual = card.canEqual(card2)
   * println(s"card can equal card2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      // Returns if its equal or not
      name == other.name
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[WeatherCard], name)
}