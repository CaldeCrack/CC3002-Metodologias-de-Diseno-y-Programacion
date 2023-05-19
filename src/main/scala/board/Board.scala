package cl.uchile.dcc
package board

import card.Card
import board.areas.{MeleeArea, RangerArea, SiegeArea, WeatherArea}

class Board {
  var meleeArea: MeleeArea = new MeleeArea()
  var rangerArea: RangerArea = new RangerArea()
  var siegeArea: SiegeArea = new SiegeArea()
  var weatherArea: WeatherArea = new WeatherArea()
  def addCard(card: Card): Unit = card.addCard(this)
}