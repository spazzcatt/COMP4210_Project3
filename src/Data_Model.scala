class Data_Model (val headers : Array[String], val data : Array[Array[String]]){

  def printData(): Unit ={
    var headerString = ""
    headers.foreach(f => headerString = headerString + f + "\t\t\t")
    println(headerString)
    var dataRow = ""
    println(s"data length = ${data.length}")
    for(i <- 0 until data.length){
      data(i).foreach(f => dataRow = dataRow + f + "\t\t\t")
      println(dataRow)
      dataRow = ""
    }

  }
  override def toString: String = "Contains: " + headers.toString()
}
