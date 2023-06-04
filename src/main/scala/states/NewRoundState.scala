package cl.uchile.dcc
package states

class NewRoundState(context: GameController) extends GameState(context) {
  override def toPlayerPlayingState(): Unit = context.state = new PlayerPlayingState(context)
}