package core

import navigation.Duas.DuasSystem
import navigation.{Engine, Planet, PlanetarySystem}

/**
  * Holds Data about the ship
  */
object Ship {
  var position: Vec3D = Vec3D(0, 0, 0)
  var planetarySystem: Option[PlanetarySystem] = Option(DuasSystem)
  var planet: Option[Planet] = Option(DuasSystem.Duas1)
  var warpFuel: Double = 100
  var impulseFuel: Double = 100
  var engine: Engine = Engine("Basic Engine", 1)
}
