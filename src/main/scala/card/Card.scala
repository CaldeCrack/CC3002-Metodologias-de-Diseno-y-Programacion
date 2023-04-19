package cl.uchile.dcc
package card

class Card(val name: String, var strength: Int = 0) {
  private val baseStrength: Int = strength

  override def equals(o: Any): Boolean = {
    if (this.getClass.getName == o.getClass.getName) {
      val otherCard = o.asInstanceOf[Card]
      this.name == otherCard.name &&
        this.strength == otherCard.strength
    } else false
  }

  def addStrength(): Unit = {
    this.strength += 1
  }

  def dupStrength(): Unit = {
    this.strength *= 2
  }

  def lowStrength(): Unit = {
    this.strength = 1
  }

  def resetStrength(): Unit = {
    this.strength = baseStrength
  }
}
