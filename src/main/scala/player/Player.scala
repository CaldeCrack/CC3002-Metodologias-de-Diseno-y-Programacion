package cl.uchile.dcc
package player

import card.Card
class Player(val name: String, var gems: Int = 2, var hand: List[Card] = List(), var deck: List[Card]) {
  override def equals(o: Any): Boolean = {
    if(this.getClass.getName == o.getClass.getName){
      val otherPlayer = o.asInstanceOf[Player]
      this.name == otherPlayer.name
    } else false
  }

  def loseGems(): Unit = {
    this.gems -= 1
  }

  def drawCard(): Unit = {

  }
}