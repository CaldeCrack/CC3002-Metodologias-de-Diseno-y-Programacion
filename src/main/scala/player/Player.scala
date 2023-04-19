package cl.uchile.dcc
package player

import scala.collection.mutable.ListBuffer
import card.Card

/** A class representing a Player.
 *
 * The Player is defined by its name, gems, which must be two initially, hand and deck of cards.
 *
 * @param name The name of the Player.
 * @param deck The cards in the deck of the Player.
 *
 * @constructor Creates a new Player with the specified name and a deck of cards.
 *
 * @example
 * {{{
 * val player = new Player("Andres")
 * var name = player.name
 * println(s"The name of the player is $name")
 * }}}
 *
 * @author Andres Calderon
 * @since 1.0.0
 * @version 1.0.0
 */
class Player(val name: String, var deck: ListBuffer[Card]) {
  var gems: Int = 2
  var hand: ListBuffer[Card] = ListBuffer()
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