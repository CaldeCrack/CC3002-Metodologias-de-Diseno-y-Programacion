package cl.uchile.dcc
package card

import java.util.Objects

/** A SiegeCard that extends UnitCard.
 *
 * A SiegeCard is defined by its name and strength.
 *
 * @param name The name of the card.
 * @param strength The strength of the card.
 *
 * @constructor Create a new SiegeCard with the given name and strength.
 *
 * @example
 * {{{
 * val siegeCard = new SiegeCard("card", 5)
 * val name = siegeCard.name
 * println(s"The name of the card is $name")
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class SiegeCard(name: String, strength: Int) extends UnitCard(name, strength){
  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val card = new SiegeCard("Card", 5)
   * val card2 = new SiegeCard("Card2", 5)
   * val _canEqual = card.canEqual(card2)
   * println(s"card can equal card2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeCard]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[SiegeCard]
      // Returns if its equal or not
      name == other.name && strength == other.strength
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[SiegeCard], name, strength)
}