package commands.files

import commands.Command
import files.IOFileNav

object Path extends Command(
  "path",
  "Tells you your current directory",
  List(),
  _ => {
    println(IOFileNav.currentDirectory)
  }
)
