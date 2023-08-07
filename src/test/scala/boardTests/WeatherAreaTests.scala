package cl.uchile.dcc
package boardTests

import board.areas.WeatherArea
import munit.FunSuite
class WeatherAreaTests extends FunSuite {
  var weatherArea: WeatherArea = _

  override def beforeEach(context: BeforeEach): Unit = weatherArea = new WeatherArea()

  test("equals") {
    val weatherArea2 = new WeatherArea()
    assert(weatherArea.canEqual(weatherArea2))
    assert(weatherArea.equals(weatherArea2))
    assert(!weatherArea.equals(null))
    assertEquals(weatherArea.##, weatherArea2.##)
    assertEquals(weatherArea.##, weatherArea2.##)
  }
}