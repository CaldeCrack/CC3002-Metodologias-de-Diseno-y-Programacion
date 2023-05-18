package cl.uchile.dcc
package cardTests

import card.nonUnitCards.WeatherCard
import munit.FunSuite
class WeatherCardTests extends FunSuite {
  val name = "WeatherCard"

  var card: WeatherCard = _
  override def beforeEach(context: BeforeEach): Unit = card = new WeatherCard(name)

  test("equals") {
    val card2 = new WeatherCard("WeatherCard")
    assert(card.canEqual(card2))
    assert(card.equals(card2))
    assert(!card.equals(null))
    assertEquals(card.##, card.##)
    assertEquals(card.##, card2.##)
  }

  test("A WeatherCard has a name"){
    assertEquals(name, card.name)
  }
}