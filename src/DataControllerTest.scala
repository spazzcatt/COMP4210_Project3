object DataControllerTest {
  def main(args: Array[String]): Unit = {
    val headers = Array("Start", "End")
    val data1 = Array(Array("1", "8"), Array("8", "12"))
    val data2 = Array(Array("1","2"), Array("2", "5"))
    val dataModel1 = new Data_Model(headers, data1)
    val dataModel2 = new Data_Model(headers, data2)
    println("TEST DataController.compareDataModels:")
    println("*" * 20 + "\n")
    //val lesser = Data_Controller.compareDataModels(dataModel1, dataModel2)
    //if(lesser == data1) println("Data1 is lesser")
    //else println("Data2 is lesser")
  }
}
