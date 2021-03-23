/*
Connor May
COMP 4210 Scala
3/23/2021
Does not work
 */

object Main {
  def main(args: Array[String]): Unit = {
    var data = new Data_Model(Array("empty"), Array(Array("Empty")))
    println(s"Parsing ${args.length} number of files into one file")
    var dataSets = Array [Data_Model]()
    for(fileName <- args){
      println(s"Getting file from: $fileName")
      data = Data_Controller.readData(fileName)
      dataSets = dataSets ++ Array(data)
      data.printData()
    }
    println()
    println("Finished getting data.")
    println()
    println("Printed Data")
    println("\n******************************")
    println("Starting Data Merge")
    println(s"Merging ${dataSets.length} number of sets")

    val newData = Data_Controller.mergeData(dataSets.toArray)
    newData.printData()
  }
}
