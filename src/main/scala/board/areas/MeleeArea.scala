package cl.uchile.dcc
package board.areas

import card.unitCards.MeleeCard
import scala.collection.mutable.ListBuffer

/** A MeleeArea that extends AbstractArea.
 *
 * A MeleeArea is defined by its list of melee cards.
 *
 * @param list contains a mutable list of melee cards.
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
class MeleeArea(var list: ListBuffer[MeleeCard] = ListBuffer()) {

}
