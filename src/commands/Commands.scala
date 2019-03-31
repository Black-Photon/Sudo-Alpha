package commands

object Commands {
  val commandList = List(
    Command("hi", "Say's Hi", List(), _ => {
      println("Hello There!")
    }),
    Command("bye", "Say's Bye", List(), _ => {
      println("Goodbye!")
    }), Help
  )
}
