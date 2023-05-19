package cl.uchile.dcc
package boardTests

import board.areas.RangerArea
import munit.FunSuite
class RangerAreaTests extends FunSuite {
  var rangerArea: RangerArea = _

  override def beforeEach(context: BeforeEach): Unit = rangerArea = new RangerArea()

  test("equals") {
    val rangerArea2 = new RangerArea()
    assert(rangerArea.canEqual(rangerArea2))
    assert(rangerArea.equals(rangerArea2))
    assert(!rangerArea.equals(null))
    assertEquals(rangerArea.##, rangerArea2.##)
    assertEquals(rangerArea.##, rangerArea2.##)
  }
}