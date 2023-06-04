package cl.uchile.dcc
package states

class PlayerPlayingState(context: GameController) extends GameState(context) {
  override def toPCPlayingState(): Unit = context.state = new PCPlayingState(context)
}
