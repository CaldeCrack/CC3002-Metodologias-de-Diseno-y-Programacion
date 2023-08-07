package cl.uchile.dcc
package state

/** A class representing the PC playing state */
class PCPlayingState(context: GameController) extends GameState(context) {
  override def toPlayerPlayingState(): Unit = context.state = new PlayerPlayingState(context)

  override def toEndRoundState(): Unit = context.state = new EndRoundState(context)
}