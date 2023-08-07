package cl.uchile.dcc
package boardTests

import board.areas.SiegeArea
import munit.FunSuite
class SiegeAreaTests extends FunSuite {
  var siegeArea: SiegeArea = _

  override def beforeEach(context: BeforeEach): Unit = siegeArea = new SiegeArea()

  test("equals") {
    val siegeArea2 = new SiegeArea()
    assert(siegeArea.canEqual(siegeArea2))
    assert(siegeArea.equals(siegeArea2))
    assert(!siegeArea.equals(null))
    assertEquals(siegeArea.##, siegeArea2.##)
    assertEquals(siegeArea.##, siegeArea2.##)
  }
}