package cl.uchile.dcc

import state.{EndGameState, EndRoundState, InitialState, NewRoundState, PCPlayingState, PlayerPlayingState}
import player.Player
import munit.FunSuite
import scala.collection.mutable.ListBuffer
class GameControllerTests extends FunSuite {
  var gameController: GameController = _
  var initialState: InitialState = _
  var playerPlayingState: PlayerPlayingState = _
  var pcPlayingState: PCPlayingState = _
  var endRoundState: EndRoundState = _
  var newRoundState: NewRoundState = _
  var endGameState: EndGameState = _

  override def beforeEach(context: BeforeEach): Unit = {
    gameController = new GameController()
    initialState = new InitialState(gameController)
    playerPlayingState = new PlayerPlayingState(gameController)
    pcPlayingState = new PCPlayingState(gameController)
    endRoundState = new EndRoundState(gameController)
    newRoundState = new NewRoundState(gameController)
    endGameState = new EndGameState(gameController)
  }

  test("Every state is accesible"){
    val player1 = new Player("Player", ListBuffer())
    val player2 = new Player("PC", ListBuffer())
    assertEquals(gameController.state, initialState)
    gameController.startGame(player1, player2)
    assertEquals(gameController.state, playerPlayingState)
    gameController.playCard()
    assertEquals(gameController.state, pcPlayingState)
    gameController.pcPlays(false)
    assertEquals(gameController.state, playerPlayingState)
    gameController.skipTurn()
    gameController.pcPlays(true)
    assertEquals(gameController.state, endRoundState)
    player1.loseGems()
    gameController.endRound()
    assertEquals(gameController.state, newRoundState)
    gameController.newRound()
    assertEquals(gameController.state, playerPlayingState)
    gameController.skipTurn()
    gameController.pcPlays(true)
    player1.loseGems()
    gameController.endRound()
    assertEquals(gameController.state, endGameState)
  }
}