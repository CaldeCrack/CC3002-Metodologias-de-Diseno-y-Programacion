package cl.uchile.dcc
package observer

/** A trait representing an Observer.
 *
 * @constructor Creates an Observer.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
trait Observer[T] {
  /** Updates info to the Observers */
  def update(observable: Subject[T], value: T): Unit
}
/** A trait representing an observable Subject.
 *
 * @constructor Creates a Subject with name and gems.
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @version 1.0
 * @since 1.0
 */
trait Subject[T] {
  /** The name of the Subject. */
  val name: String
  /** The gems of the Subject. */
  def gems: Int

  /** Adds an observer to a List of Observers */
  def addObserver(observer: Observer[T]): Unit

  /** Notifies value to the observers */
  def notifyObservers(value: T): Unit
}