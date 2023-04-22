package cl.uchile.dcc
package card

/** An abstract class representing a Card with a name and strength that extends the trait Card.
 *
 * An AbstractCard is defined by its name and strength.
 *
 * @param name The name of the card.
 * @param _strength The strength of the card.
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
abstract class AbstractCard(val name: String, var _strength: Int) extends Card{
  /** Getter for the parameter _strength.
   *
   * @return The strength of the card.
   * @example
   * {{{
   * val card = new UnitCard("Card", 5)
   * val strength = card.strength
   * println(s"card's strength is $strength")
   * }}}
   */
  def strength: Int = _strength

  /** Setter for the parameter _strength.
   *
   * @example
   * {{{
   * val card = new UnitCard("Card", 5)
   * card.strength = 6
   * val strength = card.strength
   * println(s"card's strength is $strength")
   * }}}
   */
  def strength_=(newStrength: Int): Unit = _strength = newStrength
}
