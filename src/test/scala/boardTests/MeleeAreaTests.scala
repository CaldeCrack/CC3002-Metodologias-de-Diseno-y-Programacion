package cl.uchile.dcc
package boardTests

import board.areas.MeleeArea
import munit.FunSuite
class MeleeAreaTests extends FunSuite {
  var meleeArea: MeleeArea = _

  override def beforeEach(context: BeforeEach): Unit = meleeArea = new MeleeArea()

  test("equals") {
    val meleeArea2 = new MeleeArea()
    assert(meleeArea.canEqual(meleeArea2))
    assert(meleeArea.equals(meleeArea2))
    assert(!meleeArea.equals(null))
    assertEquals(meleeArea.##, meleeArea2.##)
    assertEquals(meleeArea.##, meleeArea2.##)
  }
}