package partners.harris.woopraAPI

import scala.io.Source

import play.api.libs.json._
import play.api.libs.functional.syntax._

import play.api.libs.json.Json

import com.typesafe.scalalogging._

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/16/15.
  */
object Visitors extends LazyLogging{


  case class Document(id: Int, name: String, fileType: String)

  /**
    *
    * @return
    */
  def readFile(filePath:String): Array[String] ={

    val source = Source.fromURL(getClass.getResource("/"+filePath))
    val lines = source.getLines

    var visitors = Array()++lines

    logger.debug("processing file: "+filePath+" ,entries = " + visitors.length)

    visitors


  }

  implicit val documentReader: Reads[Document] = (
    (__ \ "id").read[Int] and
      (__ \ "name").read[String] and
      (__ \ "file_type").read[String]
    ) (Document.apply _)


  def main(args: Array[String]) {

    readFile("two-days-ago.log")
  }







}
