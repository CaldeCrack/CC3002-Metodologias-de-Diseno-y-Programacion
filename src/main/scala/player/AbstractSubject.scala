package cl.uchile.dcc
package player

import observer.{Observer, Subject}

/** An abstract class representing a Subject that extends the trait Subject.
 *
 * An AbstractSubject is defined by its observers.
 *
 * @author <a href="https://github.com/CaldeCrack">R8V</a>
 * @since 1.0
 * @version 1.0
 */
abstract class AbstractSubject[T] extends Subject[T] {
  /** Observers of the Subject */
  private var observers: List[Observer[T]] = Nil
  /** Adds an Observer to the List of Observers */
  override def addObserver(observer: Observer[T]): Unit = observers = observer :: observers

  /** Notifies value to the observers */
  override def notifyObservers(value: T): Unit = {
    for (observer <- observers) {
      observer.update(this, value)
    }
  }
}