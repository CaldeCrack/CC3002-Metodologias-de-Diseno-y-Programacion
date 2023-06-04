package cl.uchile.dcc

import player.Player
import board.Board
import states.GameState

class GameController {
  private var player1: Player = _
  private var player2: Player = _
  private var board: Board = _
  var state: GameState = new IdleState(this)

  def startGame(player_1: Player, player_2: Player): Unit = {
    player1 = player_1
    player2 = player_2
    board = new Board(player1, player2)
    state = new IdleState(this)
  }
}