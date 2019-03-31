package commands

import files._

object Ls extends Command (
  "ls",
  "Lists files in the current directory",
  List(),
  args => {
    val postfix = if (args.isEmpty) "" else args.head

    try{
      for(file <- IOFileNav ls postfix) {
        println(file)
      }
    } catch {
      case e: NotADirectoryException => println(e.getMessage)
    }
  }
)