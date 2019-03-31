package files

import java.io._

object IOFileNav extends IOClass {
  var currentDirectory: String = "ship/"
  val absolutePath: String = "src/"

  def ls(relDir: String): List[String] = {
    if(!filterDir(currentDirectory+relDir)) {
      throw new NotADirectoryException("No directory above ship")
    }

    val directory = new File(absolutePath + currentDirectory + relDir)
    var list: List[String] = List()
    val files: Array[File] = directory.listFiles

    if(files == null) throw new NotADirectoryException(currentDirectory + relDir + " is an invalid directory")

    for(file <- files) {
      list = file.getPath.substring(absolutePath.length) :: list
    }
    list
  }

  def filterDir(directory: String): Boolean = {
    var depth = 0
    var dot = false

    for(letter <- directory.toCharArray) {
      letter match {
        case '/' => depth = depth + 1
        case '.' => {
          if (dot) {
            // Reducing by 2 as must have a / before
            depth = depth - 2
          } else dot = true
        }
        case _ => dot = false
      }
      if(depth < 0) return false
    }

    true
  }
}
