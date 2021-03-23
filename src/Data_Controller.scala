import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Data_Controller {
  def readData(filename : String) : Data_Model = {
    val fileLines = Source.fromFile(filename).getLines()
    val header = fileLines.next().split(",")
    val tailOfFile = fileLines.toList
    val data = Array.ofDim[String](tailOfFile.length, header.length)
    var index = 0
    for (line <- tailOfFile){
      data(index) = line.split(",")
      index = index + 1
    }

    new Data_Model(header, data)
  }

  /**
   * NOTE: only works on 2 Data_Models right now
   * @param lists a list of Data_Models to merge
   * @return
   */
  def mergeData(lists : Array[Data_Model]): Data_Model ={
    val data_Model1 = lists(0)
    val data_Model2 = lists(1)
    val data1 = data_Model1.data
    val data2 = data_Model2.data
    data_Model2.headers.drop(2)
    val newHeader = data_Model1.headers ++ data_Model2.headers
    var indexData1 = 0
    var indexData2 = 0
    var result = Array.fill[Array[String]](data1.length + data2.length)(Array(""))
    var resultIndex = 0
    var model1Start = data1(indexData1)(0).toInt
    var model1End = data1(indexData1)(1).toInt
    var model2Start = data2(indexData2)(0).toInt
    var model2End = data2(indexData2)(1).toInt
    var model1DiffTotal = 0
    var model2DiffTotal = 0
    model1DiffTotal = model1DiffTotal + (model1End - model1Start)
    model2DiffTotal = model2DiffTotal + (model2End - model2Start)
    while(indexData1 != data1.length && indexData2 != data2.length){
      model1Start = data1(indexData1)(0).toInt
      model1End = data1(indexData1)(1).toInt
      model2Start = data2(indexData2)(0).toInt
      model2End = data2(indexData2)(1).toInt

      val temp1 = data1(indexData1).drop(2)
      val temp2 = data2(indexData2).drop(2)
      if(model1DiffTotal < model2DiffTotal){
        result(resultIndex) = Array(model1Start.toString, model1End.toString) ++ temp1 ++ temp2
        resultIndex = resultIndex + 1
        indexData1 = indexData1 + 1
      }else{
        result(resultIndex) = Array(model2Start.toString, model2End.toString) ++ temp1 ++ temp2
        resultIndex = resultIndex + 1
        indexData2 = indexData2 + 1
      }
      model1DiffTotal = model1DiffTotal + (model1End - model1Start)
      model2DiffTotal = model2DiffTotal + (model2End - model2Start)
    }
    println(s"New Headers:\n$newHeader")
    new Data_Model(newHeader, result)
  }

  /*
  /**
   * returns the lesser of two data models
   * @param dataModel1
   * @param dataModel2
   * @return the lesser of two data models
   */

  private def compareDataModels(dataModel1 : Data_Model, dataModel2 : Data_Model): Data_Model ={
    val model1Start = dataModel1.data(0)(0)
    val model1End = dataModel1.data(0)(1)
    val model2Start = dataModel2.data(0)(0)
    val model2End = dataModel2.data(0)(1)
    var returnValue = new Data_Model(Array[String](), Array[Array[String]]())
    if(model1Start.toInt <= model2Start.toInt || model1End.toInt <= model2End.toInt)  dataModel1
    else
      dataModel2
  }
*/

}
