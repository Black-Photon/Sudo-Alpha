package navigation

import navigation.PlanetType.PlanetType

/**
  * Defines a planet
  * @param name Planet name
  * @param density Density of the planet. 0.5 is pure gas, 1 is liquid, 5 is rock, 20 is very heavy
  * @param radius Radius of the planet in m. Earth is 6000
  */
case class Planet(name: String, density: Float, radius: Float) {
  def planetType: PlanetType = {
    if (density < 1) PlanetType.GAS_GIANT
    else PlanetType.ROCKY
  }
}
