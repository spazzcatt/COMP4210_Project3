import scala.io.Source

object Data_Controller {
  def readData(filename : String) : Data_Model = {
    val fileLines = Source.fromFile(filename).getLines()
    val header = fileLines.next().split(",").toList
    val tailOfFile = fileLines.toList
    val data = List[List[String]]()
    tailOfFile.foreach(f => data ++ f.split(","))
    new Data_Model(header, data)
  }

}
