package cl.uchile.dcc
package state

import java.util.Objects

class GameState(val context: GameController) extends Equals {
  context.state = this

  def toInitialState(): Unit = transitionError("InitialState")

  def toPlayerPlayingState(): Unit = transitionError("PlayerPlayingState")

  def toPCPlayingState(): Unit = transitionError("PCPlayingState")

  def toEndRoundState(): Unit = transitionError("EndRoundState")

  def toNewRoundState(): Unit = transitionError("NewRoundState")

  def toEndGameState(): Unit = transitionError("EndGameState")

  def doAction():Unit = {}

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(s"Cannot transition from ${getClass.getSimpleName} to $targetState")
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[GameState]

  override def equals(that: Any): Boolean = {
    // If [that] can equal this object then make the comparisons, otherwise return false
    if (canEqual(that)) {
      val other = that.asInstanceOf[GameState]
      // Returns if its equal or not
      context == other.context
    } else false
  }

  override def hashCode: Int = Objects.hash(classOf[GameState], context)
}