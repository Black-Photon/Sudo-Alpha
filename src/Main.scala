import commands.Commands._
import commands.InvalidCommandException

object Main extends App {
  println("Welcome to Sudo Alpha")
  while (true) {
    print(" > ")
    val input = scala.io.StdIn.readLine()
    val inputList = separateToWords(input)
    for (command <- commandList) {
      if(inputList.head == command.name) {
        try {
          command.command(inputList.tail)
        } catch {
          case e: InvalidCommandException => {
            println(e.getMessage)
          }
        }
      }
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