package cl.uchile.dcc
package observer

trait Observer[T] {
  def update(observable: Subject[T], value: T): Unit
}

trait Subject[T] {
  val name: String
  def gems: Int
  def addObserver(observer: Observer[T]): Unit

  def notifyObservers(value: T): Unit
}