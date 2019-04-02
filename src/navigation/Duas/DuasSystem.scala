package navigation.Duas

import core.Vec3D
import navigation.{Planet, PlanetarySystem}

object DuasSystem extends PlanetarySystem {
  override val planets: List[Planet] = List(Duas1, Duas2, Duas3)
  override val position: Vec3D = Vec3D(0, 0, 0)
  override val name: String = "Duas"

  object Duas1 extends Planet("Duas-1", 6, 3000)
  object Duas2 extends Planet("Duas-2", 1.1f, 7000)
  object Duas3 extends Planet("Duas-3", 9, 12000)
}