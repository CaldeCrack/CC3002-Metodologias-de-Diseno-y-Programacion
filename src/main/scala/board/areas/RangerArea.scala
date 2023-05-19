package cl.uchile.dcc
package board.areas

import card.unitCards.RangerCard
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
class RangerArea(var list: ListBuffer[RangerCard] = ListBuffer()) {

}