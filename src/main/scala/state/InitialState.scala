package cl.uchile.dcc
package state

/** A class representing the initial state */
class InitialState(context: GameController) extends GameState(context) {
  override def toPlayerPlayingState(): Unit = context.state = new PlayerPlayingState(context)
}