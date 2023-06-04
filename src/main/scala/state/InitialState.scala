package cl.uchile.dcc
package state

class InitialState(context: GameController) extends GameState(context) {
  override def toPlayerPlayingState(): Unit = context.state = new PlayerPlayingState(context)
}