package cl.uchile.dcc
package states

class GameState(val context: GameController) {
  context.state = this

  def toInitialState(): Unit = transitionError("InitialState")

  def toPlayerPlayingState(): Unit = transitionError("PlayerMenuState")

  def toPCPlayingState(): Unit = transitionError("PCPlayingState")

  def toEndRoundState(): Unit = transitionError("RoundEndState")

  def toNewRoundState(): Unit = transitionError("NewRoundState")

  def toEndGameState(): Unit = transitionError("EndGameState")

  def doAction():Unit = {}

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
    s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}