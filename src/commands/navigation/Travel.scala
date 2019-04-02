package commands.navigation

import commands.{Command, InvalidCommandException}
import core.{Ship, Vec3D}
import navigation.Galaxy

object Travel extends Command(
  "travel",
  "Flies to the given coordinates",
  List(),
  args => {
    if(args.length < 4) throw new InvalidCommandException("Not enough parameters")
    if(args.length > 4) throw new InvalidCommandException("Too many parameters")
    try{
      val position: Vec3D = Vec3D(args(0).toDouble, args(1).toDouble, args(2).toDouble)
      val speed: Double = args(3).toDouble
      val time: Double = (position - Ship.position).magnitude / speed

      println(f"Preparing to travel to coordinates $position at Warp $speed%1.1f")
      println(f"The journey will take $time%1.1f seconds")
      println(f"This will use up ${speed}ml Warp Fuel and $time%1.1fml Impulse Fuel")
      println(f"Your tanks are currently at ${Ship.warpFuel}%1.1fml Warp Fuel and ${Ship.impulseFuel}%1.1fml Impulse Fuel")
      println("Are you sure you want to continue?")
      val input = scala.io.StdIn.readLine()
      if(input.toLowerCase() == "y" || input.toLowerCase() == "yes") {
        println("Activating Warp Drive...")
        synchronized(wait(1000))
        println("Projecting Course...")
        synchronized(wait(560))
        println("Engaging Impulse Drive...")
        synchronized(wait(3400))
        println(f"Warp System Successfully Engaged at Warp $speed%1.1f")
        synchronized(wait(50))
        println("Impulse Engines Active")
        synchronized(wait(10))
        println("Warp achieved successfully")

        val startTime = System.currentTimeMillis
        val initialWarp = Ship.warpFuel
        val initialImpulse = Ship.impulseFuel
        val initialPosition = Ship.position
        val finalWarp = Ship.warpFuel - speed
        val finalImpulse = Ship.impulseFuel - time


        while(System.currentTimeMillis - startTime < time*1000) {
          val timeElapsed = System.currentTimeMillis - startTime
          val percentage: Double = timeElapsed/(time*1000)

          if(Ship.warpFuel <= 0) {
            Ship.warpFuel = 0
            throw new InvalidCommandException("Ran out of warp fuel!")
          }
          if(Ship.impulseFuel <= 0) {
            Ship.impulseFuel = 0
            throw new InvalidCommandException("Ran out of impulse fuel!")
          }

          flightMenu()
          Ship.warpFuel = initialWarp - speed * percentage
          Ship.impulseFuel = initialImpulse - time * percentage
          Ship.position = initialPosition + (position - initialPosition) * percentage
          synchronized(wait(1000))
        }

        for(_ <- 1 to 100) {
          println()
        }

        Ship.warpFuel = finalWarp
        Ship.impulseFuel = finalImpulse
        Ship.position = position
        Ship.planet = None
        println(s"Successfully arrived at $position")

        Ship.planetarySystem = Option(Galaxy.findSystem(position))

        def flightMenu(): Unit = {
          for(_ <- 1 to 100) {
            println()
          }

          println(f"Travelling at Warp...\tSpeed is $speed%1.1f. Time is ${(System.currentTimeMillis - startTime)/1000}s")
          println(f"Fuel Status: Warp - ${Ship.warpFuel}%1.1fml, Impulse - ${Ship.impulseFuel}%1.1fml")
          println(s"Current Position is ${Ship.position}")
        }
      } else {
        println("Operation Cancelled")
      }
    } catch {
      case _: NumberFormatException => throw new InvalidCommandException("Paramaters must be floats")
    }
  }
)
