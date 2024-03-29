package cl.uchile.dcc
package state

/** A class representing the player playing state */
class PlayerPlayingState(context: GameController) extends GameState(context) {
  override def toPCPlayingState(): Unit = context.state = new PCPlayingState(context)
}
