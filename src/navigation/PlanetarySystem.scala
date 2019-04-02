package navigation

import core.Vec3D

abstract class PlanetarySystem {
  val planets: List[Planet]
  val position: Vec3D
  val name: String
}
