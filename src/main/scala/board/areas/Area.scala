package cl.uchile.dcc
package board.areas

trait Area {
  /** Adds automatically a card onto its corresponding area. */
  def addCard(): Unit
}