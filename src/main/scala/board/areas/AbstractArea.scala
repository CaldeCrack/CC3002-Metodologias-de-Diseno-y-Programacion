package cl.uchile.dcc
package board.areas

import card.Card
import scala.collection.mutable.ListBuffer

/** An abstract class representing a Board that extends the trait Board.
 *
 * An AbstractArea is defined by its list of cards.
 *
 * @param _list contains a mutable list of cards.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
abstract class AbstractArea(private val _list: ListBuffer[Card]) extends Area{
  /** Getter for the parameter _list. */
  def list: List[Card] = _list.toList

  /** Adds a card to the list. */
  override def addCard(card: Card): Unit = _list.addOne(card)
}
