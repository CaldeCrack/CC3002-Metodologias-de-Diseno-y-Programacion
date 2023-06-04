package cl.uchile.dcc
package state

class PCPlayingState(context: GameController) extends GameState(context) {
  override def toPlayerPlayingState(): Unit = context.state = new PlayerPlayingState(context)

  override def toEndRoundState(): Unit = context.state = new EndRoundState(context)
}