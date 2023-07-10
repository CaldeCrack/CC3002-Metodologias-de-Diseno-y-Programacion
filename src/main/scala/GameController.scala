package cl.uchile.dcc

import player.{Player, WinCondition}
import board.Board
import state.{GameState, InitialState}
import observer.{Observer, Subject}

class GameController extends Observer[WinCondition]{
  private var player1: Player = _
  private var player2: Player = _
  private var board: Board = _
  var state: GameState = new InitialState(this)

  override def update(subject: Subject[WinCondition], value: WinCondition): Unit = {
    println(s"${subject.name} loses the game")
  }

  def startGame(player_1: Player, player_2: Player): Unit = {
    state = new InitialState(this)
    player1 = player_1
    player2 = player_2
    player1.addObserver(this)
    player2.addObserver(this)
    board = new Board(player1, player2)
    state.toPlayerPlayingState()
  }

  def playCard(): Unit = {
    state.toPCPlayingState()
  }

  def skipTurn(): Unit = {
    state.toPCPlayingState()
  }

  def pcPlays(playerSkip: Boolean): Unit = {
    val pcSkip = true // by default pc skips turn for simplicity of this submission
    if(pcSkip && playerSkip){
      state.toEndRoundState()
    } else {
      state.toPlayerPlayingState()
    }
  }

  def endRound(): Unit = {
    if(player1.gems == 0 || player2.gems == 0){
      state.toEndGameState()
    } else {
      state.toNewRoundState()
    }
  }

  def newRound(): Unit = {
    state.toPlayerPlayingState()
  }
}