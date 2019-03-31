package commands

import commands.Commands._
import scala.util.control.Breaks._

object Help extends Command (
  "help",
  "Gives a description of all commands",
  List(),
  list => {
    if(list.length < 1) throw new InvalidCommandException("Please specify which command you want help with")
    if (list.length > 1) throw new InvalidCommandException("Too Many Arguments")

    val element = list.head
    var found = false
    breakable {
      for (command <- commandList) {
        if (command.name == element) {
          println(command.help)
          found = true
          break
        }
      }
    }
    if (!found) throw new InvalidCommandException("No Such Command")
  }
)
