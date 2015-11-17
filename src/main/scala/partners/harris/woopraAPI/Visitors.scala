package partners.harris.woopraAPI

import scala.io.Source

import play.api.libs.json._
import play.api.libs.functional.syntax._


import com.typesafe.scalalogging._

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/16/15.
  */
object Visitors extends LazyLogging{



  //case class for storing
  case class Visitor(continent : String)



  /**
    * reads json file
    * @return array of raw json strings
    */
  def readFile(filePath:String): Array[String] ={

    val source = Source.fromURL(getClass.getResource("/"+filePath))
    val lines = source.getLines

    var visitors = Array()++lines

    logger.debug("processing file: "+filePath+" ,entries = " + visitors.length)

    visitors

  }


  /**
    * parses json and creates data structure for storing parsed data
    * @param content json string
    * @return list of parsed objects
    */
  def parse(content :Array[String]) : Array[Visitor] = {

    var res =  Array[Visitor]()

    var e= for(v <- content) yield {

      val jsonValue = Json.parse(v)
      (jsonValue \ "continent").as[String]

    }

    //do here


    res


  }

  implicit val documentReader: Reads[Visitor] = (
    (__ \ "content").read[String]
    ) (Visitor.apply _)


  def main(args: Array[String]) {

    var content = readFile("two-days-ago.log")


    parse(content)

  }







}
