package cl.uchile.dcc
package states

class EndRoundState(context: GameController) extends GameState(context) {
  override def toNewRoundState(): Unit = context.state = new NewRoundState(context)

  override def toEndGameState(): Unit = context.state = new EndGameState(context)
}