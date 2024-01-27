import scala.io.{BufferedSource, Source}
import scala.io.Source.{createBufferedSource, fromFile}
import scala.collection.immutable.ListMap
object Data extends App{

    val source: BufferedSource = fromFile("/Users/sergey/Desktop/lab1/u.data")
    val lines: Seq[Array[String]] = source.getLines.toList.map(_.split("\t").slice(1,3))
    source.close()

  val lines405: Seq[Array[String]] = lines.filter(x=> x(0)=="405")
  val grouplines405: Map[String,Int] = lines405.map(x=>x(1)).groupBy(identity).mapValues(_.size)
  val sortgrouplines405: Map[String,Int] =  ListMap(grouplines405.toSeq.sortBy(_._1):_*)

  val grouplinesAll: Map[String,Int] = lines.map(x=>x(1)).groupBy(identity).mapValues(_.size)
  val sortgrouplinesAll: Map[String,Int] =  ListMap(grouplinesAll.toSeq.sortBy(_._1):_*)
// {"hist_film":[11,22,33,44,55],"hist_all":[134,123,782,356,148]}
 val aJson:String = "{\"hist_film\":["+sortgrouplines405.values.mkString(",")+"],\"hist_all\":["+sortgrouplinesAll.values.mkString(",")+"]}"
 println(aJson)



}
