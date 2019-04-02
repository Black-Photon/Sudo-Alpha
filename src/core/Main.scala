package core

import commands.Commands.commandList
import commands.InvalidCommandException

object Main extends App {
  println("Welcome to Sudo Alpha")
  while (true) {
    print(" > ")
    val input = scala.io.StdIn.readLine()
    val inputList = separateToWords(input)

    val commandMatch = commandList.filter(command => inputList.head == command.name)

    if(commandMatch.isEmpty) {
      println("Command not found")
    } else if(commandMatch.length == 1) {
      val command = commandMatch.head

      try {
        command.command(inputList.tail)
      } catch {
        case e: InvalidCommandException => println(e.getMessage)
      }
    } else {
      throw new RuntimeException("Multiple commands of same name found")
    }
  }

  def separateToWords(s: String): List[String] = {
    def separate(remaining: String, current: String): List[String] = remaining match {
      case "" => List(current)
      case _ => remaining.head match {
        case ' ' => current :: separate (remaining.tail, "")
        case _ => separate (remaining.tail, current.concat (remaining.head.toString) )
      }
    }

    separate(s, "")
  }
}
