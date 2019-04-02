package commands.navigation

import commands.Command
import core.Ship

object Fuel extends Command(
  "fuel",
  "Tells you the current Fuel Level",
  List(),
  _ => {
    println(f"Warp Fuel Level: ${Ship.warpFuel}%1.1fml")
    println(f"Impulse Fuel Level: ${Ship.impulseFuel}%1.1fml")
  }
)
