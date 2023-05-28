package cl.uchile.dcc
package board.areas

import card.Card
import scala.collection.mutable.ListBuffer

/** An abstract class representing a Board that extends the trait Board.
 *
 * An AbstractArea is defined by its list of cards.
 *
 * @param list contains a mutable list of cards.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
abstract class AbstractArea(val list: ListBuffer[Card]) extends Area
