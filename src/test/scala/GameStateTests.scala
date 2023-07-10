package cl.uchile.dcc

import state.{EndGameState, EndRoundState, GameState, InitialState, NewRoundState, PCPlayingState, PlayerPlayingState}
import munit.FunSuite
class GameStateTests extends FunSuite {
  var gameController: GameController = _
  var gameState: GameState = _
  var initialState: InitialState = _
  var playerPlayingState: PlayerPlayingState = _
  var pcPlayingState: PCPlayingState = _
  var endRoundState: EndRoundState = _
  var newRoundState: NewRoundState = _
  var endGameState: EndGameState = _
  override def beforeEach(context: BeforeEach): Unit = {
    gameController = new GameController()
    gameState = new GameState(gameController)
    initialState = new InitialState(gameController)
    playerPlayingState = new PlayerPlayingState(gameController)
    pcPlayingState = new PCPlayingState(gameController)
    endRoundState = new EndRoundState(gameController)
    newRoundState = new NewRoundState(gameController)
    endGameState = new EndGameState(gameController)
  }
  test("Equals") {
    val gameState2 = new GameState(gameController)
    assert(gameState.canEqual(gameState2))
    assert(gameState.equals(gameState2))
    assert(!gameState.equals(null))
    assertEquals(gameState.##, gameState2.##)
    assertEquals(gameState.##, gameState2.##)
  }

  test("Invalid Transitions") {
    var thrown = intercept[Exception] {gameState.toInitialState()}
    assert(thrown.getMessage == s"Cannot transition from GameState to InitialState")
    thrown = intercept[Exception] {gameState.toPlayerPlayingState()}
    assert(thrown.getMessage == s"Cannot transition from GameState to PlayerPlayingState")
    thrown = intercept[Exception] {gameState.toPCPlayingState()}
    assert(thrown.getMessage == s"Cannot transition from GameState to PCPlayingState")
    thrown = intercept[Exception] {gameState.toEndRoundState()}
    assert(thrown.getMessage == s"Cannot transition from GameState to EndRoundState")
    thrown = intercept[Exception] {gameState.toNewRoundState()}
    assert(thrown.getMessage == s"Cannot transition from GameState to NewRoundState")
    thrown = intercept[Exception] {gameState.toEndGameState()}
    assert(thrown.getMessage == s"Cannot transition from GameState to EndGameState")
  }
}
