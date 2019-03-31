package commands

import commands.Commands._

object Help extends Command (
  "help",
  "Gives a description of all commands",
  List(),
  args => {
    if(args.length < 1) throw new InvalidCommandException("Please specify which command you want help with")
    if (args.length > 1) throw new InvalidCommandException("Too Many Arguments")



    val element = args.head
    val commandMatch = commandList.filter(command => element == command.name)

    if(commandMatch.isEmpty) {
      println("Command not found")
    } else if(commandMatch.length == 1){
      val command = commandMatch.head

      println(command.help)
    } else {
      throw new RuntimeException("Multiple commands of same name found")
    }
  }
)
