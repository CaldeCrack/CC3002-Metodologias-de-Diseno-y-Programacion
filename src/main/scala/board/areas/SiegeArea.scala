package cl.uchile.dcc
package board.areas

import card.unitCards.SiegeCard
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
class SiegeArea(var list: ListBuffer[SiegeCard] = ListBuffer()) {

}