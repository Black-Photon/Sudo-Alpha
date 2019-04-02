package commands

import commands.files.{Cd, Ls, Path}

object Commands {
  val commandList = List(
    Say, Help, Ls, Cd, Path
  )
}
