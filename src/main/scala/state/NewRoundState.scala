package cl.uchile.dcc
package state

/** A class representing the new round state */
class NewRoundState(context: GameController) extends GameState(context) {
  override def toPlayerPlayingState(): Unit = context.state = new PlayerPlayingState(context)
}