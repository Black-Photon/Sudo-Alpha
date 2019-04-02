package navigation

import core.Vec3D
import navigation.Duas.DuasSystem

object Galaxy {
  val systems = List(DuasSystem)

  def findSystem(pos: Vec3D): PlanetarySystem = {
    for(system <- systems) {
      if (pos == system.position) {
        return system
      }
    }
    null
  }
}
