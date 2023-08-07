package cl.uchile.dcc
package state

import java.util.Objects

/** A class representing the game state */
class GameState(val context: GameController) extends Equals {
  /** Set the state */
  context.state = this
  /** Change to initial state */
  def toInitialState(): Unit = transitionError("InitialState")

  /** Change to player playing state */
  def toPlayerPlayingState(): Unit = transitionError("PlayerPlayingState")

  /** Change to PC playing state */
  def toPCPlayingState(): Unit = transitionError("PCPlayingState")

  /** Change to end round state */
  def toEndRoundState(): Unit = transitionError("EndRoundState")

  /** Change to new round state */
  def toNewRoundState(): Unit = transitionError("NewRoundState")

  /** Change to end game state */
  def toEndGameState(): Unit = transitionError("EndGameState")

  /** Do an action */
  // def doAction(): Unit = ??? // nothing for now

  /** Trigger a transition error */
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(s"Cannot transition from ${getClass.getSimpleName} to $targetState")
  }

  /** Returns if the parameter can equals this object.
   *
   * @param that object that is trying to compare to this object.
   * @return If can equal this object.
   * @example
   * {{{
   * val gameState = new GameState(...)
   * val gameState2 = new GameState(...)
   * val _canEqual = gameState.canEqual(gameState2)
   * println(s"gameState can equal gameState2 is $_canEqual")
   * }}}
   */
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