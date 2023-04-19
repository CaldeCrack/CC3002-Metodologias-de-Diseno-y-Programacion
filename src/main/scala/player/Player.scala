package cl.uchile.dcc
package player

import scala.collection.mutable.ListBuffer
import card.Card
class Player(val name: String, var gems: Int = 2, var hand: ListBuffer[Card] = ListBuffer(), var deck: ListBuffer[Card]) {
  private var maxHand: Boolean = false
  private var emptyDeck: Boolean = false
  private var curHand: Int = 9
  private var curDeck: Int = 24

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
    if(!maxHand){
      this.hand.addOne(deck.last)
      curHand+=1
      this.deck.remove(curDeck)
      curDeck-=1
    }
    if(curHand == 9) {maxHand = true}
  }
}