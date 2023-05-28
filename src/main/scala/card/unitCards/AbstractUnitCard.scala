package cl.uchile.dcc
package card.unitCards

import card.{Card, StrengthCapable}

/** An abstract class representing a Card with a name and strength that extends the trait Card.
 *
 * An AbstractCard is defined by its name and strength.
 *
 * @param _name The name of the card.
 * @param _strength The strength of the card.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
abstract class AbstractUnitCard(val _name: String, var _strength: Int) extends Card with StrengthCapable{
  /** Getter for the parameter _name. */
  def name: String = _name

  /** Getter for the parameter _strength. */
  def strength: Int = _strength

  /** Variable that stores the original strength value of the card in case it's modified */
  private val baseStrength: Int = _strength

  /** Add 1 to the actual strength of the card */
  override def addStrength(): Unit = _strength += 1

  /** Duplicates the actual strength of the card */
  override def dupStrength(): Unit = _strength *= 2

  /** Sets the strength of the card to 1 */
  override def lowStrength(): Unit = _strength = 1

  /** Resets the strength of the card to its original value */
  override def resetStrength(): Unit = _strength = baseStrength
}