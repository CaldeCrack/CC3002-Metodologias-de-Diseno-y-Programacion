package cl.uchile.dcc
package card

import java.util.Objects

/** A RangerCard that extends UnitCard.
 *
 * A RangerCard is defined by its name and strength.
 *
 * @param name The name of the card.
 * @param strength The strength of the card.
 *
 * @constructor Create a new RangerCard with the given name and strength.
 *
 * @example
 * {{{
 * val rangerCard = new RangerCard("card", 5)
 * val name = rangerCard.name
 * println(s"The name of the card is $name")
 * }}}
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class RangerCard(name: String, strength: Int) extends UnitCard(name, strength){
  /** Returns if the parameter can equal this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val card = new RangerCard("Card", 5)
   * val card2 = new RangerCard("Card2", 5)
   * val _canEqual = card.canEqual(card2)
   * println(s"card can equal card2 is $_canEqual")
   * }}}
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[RangerCard]

  /** Returns if the parameter equals this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If is equal to this object.
   * @example
   * {{{
   * val card = new RangerCard("Card", 5)
   * val card2 = new RangerCard("Card2", 5)
   * val _equals = card.equals(card2)
   * println(s"card equals card2 is $_equals")
   * }}}
   */
  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[RangerCard]
      // Returns if its equal or not
      name == other.name && strength == other.strength
    } else false
  }

  /** Generates a hash code for this object.
   *
   * A hash code is a unique number that represents an object, its particularity is that this value will
   * always be the same if the object has the same parameters, so it can be used to compare objects.
   *
   * @return An integer.
   * @example
   * {{{
   * val card = new RangerCard("card", 5)
   * val hashCodeCard = card.##
   * println(s"The hash code of the card is $hashCodeCard")
   * }}}
   */
  override def hashCode: Int = {
    Objects.hash(classOf[RangerCard], name, strength)
  }
}