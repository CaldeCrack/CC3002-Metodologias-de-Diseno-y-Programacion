package cl.uchile.dcc
package card

import java.util.Objects

/** A NonUnitCard that extends AbstractCard and the trait Card.
 *
 * A NonUnitCard is defined by its name.
 *
 * @param name The name of the card.
 *
 * @constructor Create a new NonUnitCard with the given name and strength.
 *
 * @example
 * {{{
 * val nonUnitCard = new NonUnitCard("card")
 * val name = nonUnitCard.name
 * println(s"The name of the card is $name")
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class NonUnitCard(name: String) extends AbstractCard(name, 0) with Equals {
  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val card = new NonUnitCard("Card")
   * val card2 = new NonUnitCard("Card2")
   * val _canEqual = card.canEqual(card2)
   * println(s"card can equal card2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[NonUnitCard]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if(canEqual(that)) {
      val other = that.asInstanceOf[NonUnitCard]
      // Returns if its equal or not
      name == other.name && strength == other.strength
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[NonUnitCard], name, strength)
}