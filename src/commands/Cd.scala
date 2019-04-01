package commands

import files._

object Cd extends Command(
  "cd",
  "Changes your current directory",
  List(),
  args => {
    val postfix = if (args.isEmpty) "" else args.head

    try{
      IOFileNav cd postfix
    } catch {
      case e: NotADirectoryException => println(e.getMessage)
    }
  }
)
