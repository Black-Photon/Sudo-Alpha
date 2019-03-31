package commands

object Say extends Command(
  "say",
  "Repeats the string you give it",
  List(),
  args => {
    println(args mkString " ")
  }
)
