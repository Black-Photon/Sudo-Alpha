package commands

/**
  * Class for a command
  * @param name Command name
  * @param help Help message
  * @param command Command function (What it does)
  */
case class Command(name: String, help: String, subcommands: List[Command], command: List[String] => Unit)
