package commands.navigation

import commands.Command
import core.Ship

object Here extends Command(
  "here",
  "Tells you your current location",
  List(),
  _ => {
    println(s"Galactic Coordinates: ${Ship.position}")
    def systemString: String = {
      Ship.planetarySystem match {
        case Some(system) => system.name
        case _ => "None"
      }
    }
    def planetString: String = {
      Ship.planet match {
        case Some(planet) => planet.name
        case _ => "None"
      }
    }
    println(s"Planetary System: $systemString")
    println(s"Current Planet: $planetString")
  }
)