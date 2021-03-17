object Main {
  def main(args: Array[String]): Unit = {
    println(s"Parsing ${args.length} number of files into one file")
    val dataSets = List[Data_Model]()
    for(fileName <- args){
      println(s"Getting file from: $fileName")
      val data = Data_Controller.readData(fileName)
      dataSets :: List(data)
      println("Data read: ")
      println(data.toString)
    }
    println()
    println("Finished getting data.")
    println()
  }
}
