package cl.uchile.dcc

import player.{Player, WinCondition}
import board.Board
import state.{GameState, InitialState}
import observer.{Observer, Subject}

/** A class representing the game controller that extends Observer.
 *
 * @constructor Creates a GameController.
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class GameController extends Observer[WinCondition]{
  /** The 2 players */
  private var player1: Player = _
  private var player2: Player = _
  /** The board */
  private var board: Board = _
  /** The initial state */
  var state: GameState = new InitialState(this)
  /** Updates info to the Observers */
  override def update(subject: Subject[WinCondition], value: WinCondition): Unit = {
    println(s"${subject.name} loses the game")
  }

  /** Initializes a new game from the initial state */
  def startGame(player_1: Player, player_2: Player): Unit = {
    state = new InitialState(this)
    player1 = player_1
    player2 = player_2
    player1.addObserver(this)
    player2.addObserver(this)
    board = new Board(player1, player2)
    state.toPlayerPlayingState()
  }

  /** Changes the state when the player plays a card */
  def playCard(): Unit = {
    state.toPCPlayingState()
  }

  /** Changes the state when the player skips its turn */
  def skipTurn(): Unit = {
    state.toPCPlayingState()
  }

  /** Changes the state when the PC plays */
  def pcPlays(playerSkip: Boolean): Unit = {
    val pcSkip = true // by default pc skips turn for simplicity of this submission
    if(pcSkip && playerSkip){
      state.toEndRoundState()
    } else {
      state.toPlayerPlayingState()
    }
  }

  /** Changes the state when the round ends */
  def endRound(): Unit = {
    if(player1.gems == 0 || player2.gems == 0){
      state.toEndGameState()
    } else {
      state.toNewRoundState()
    }
  }

  /** Changes the state when there is a new round */
  def newRound(): Unit = {
    state.toPlayerPlayingState()
  }
}