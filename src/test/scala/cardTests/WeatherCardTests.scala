package cl.uchile.dcc
package cardTests

import card.WeatherCard
import munit.FunSuite
class WeatherCardTests extends FunSuite {
  val name = "WeatherCard"

  var card: WeatherCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    card = new WeatherCard(name)
  }

  test("equals") {
    val card2 = new WeatherCard("WeatherCard")
    assertEquals(card, card)
    assertEquals(card, card2)
  }
}
