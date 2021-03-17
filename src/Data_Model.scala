class Data_Model (val headers : List[String], val data : List[List[String]]){
  override def toString: String = "Contains: " + headers.toString()
}
