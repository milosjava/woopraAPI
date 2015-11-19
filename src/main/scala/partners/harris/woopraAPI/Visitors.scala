package partners.harris.woopraAPI

import scala.io.Source

import play.api.libs.json._
import play.api.libs.functional.syntax._


import com.typesafe.scalalogging._

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/16/15.
  */
object Visitors extends LazyLogging{



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


    val res= for(row <- content) yield {
      Json.parse(row).as[Visitor]
    }

    res


  }

  //case class for storing json data
  case class Action( duration: Int, name: String, properties_dn : String, properties_permalink:String)

  //case class for storing json data
  case class Visitor( date: String, pid: String, name : String, fingerprint:String, actions : List[Action])



  implicit val actionReader: Reads[Action] = (
    (__ \ "duration").read[Int] and
      ((__ \ "name").read[String] or Reads.pure("")) and
      (__ \ "properties" \ "dn").read[String] and
      ((__ \ "properties" \ "permalink").read[String] or Reads.pure(""))
    ) (Action.apply _)

  implicit val visitorReader: Reads[Visitor] = (
    (__ \ "date").read[String] and
      (__ \ "pid").read[String] and
      ((__ \ "visitor" \ "name").read[String] or Reads.pure("")) and
      ((__ \ "visitor" \ "fingerprint").read[String] or Reads.pure("")) and
      (__ \ "actions").read[List[Action]]
    ) (Visitor.apply _)


  def main(args: Array[String]) {

    var content = readFile("harrisPartners_2015-11-17_2.log")

//    var row = """{"continent":"EU","date":"2015-11-18","country":"RS","city":"Pančevo","timezone":"Europe/Belgrade","screen":"1920x1080","description":"","language":"English","pid":"ggTQYfnwkMYG","type":"visit","resolution":"1920x1080","second":0,"duration":444,"number":5,"post":"","browser":"Chrome","lat":44.8708,"hour_of_day":2,"os":"Linux","lng":20.6403,"offset":"+01:00","method":"","org":"","ip":"89.216.152.115","h":"ggTQYfnwkMYG","minute":21,"referrer":{"query":"","type":"direct","url":""},"time":1447773660085,"region":"Vojvodina","visitor":{"name":"Milos","fingerprint":"2798630358","first_visit_time":"1447678760470","first_referrer_type":"direct"},"device":"desktop","actions":[{"duration":432,"date":"2:21:12 AM","domain":"harris.partners","name":"wp article","time":1447773672068,"properties":{"author":"Tim Doyle","name":"wp article","dn":"432","permalink":"http://harris.partners/the-challenge-of-owning-moments/","title":"The challenge of owning moments","category":"Blog","post date":"1443532696000"}},{"duration":10,"date":"2:21:04 AM","exit":true,"domain":"harris.partners","name":"pv","time":1447773664139,"properties":{"domain":"harris.partners","name":"pv","dn":"10","title":"\n\nThought Leadership - Harris Partners | We are revolutionising customer engagement through digital &amp; big data.","uri":"http://harris.partners/thought-leadership/","url":"/thought-leadership/"}},{"duration":10,"date":"2:21:00 AM","landing":true,"domain":"harris.partners","name":"pv","time":1447773660085,"properties":{"domain":"harris.partners","name":"pv","dn":"10","title":"\n\nHarris Partners | Home Page | We are revolutionising customer engagement through digital &amp; big data.","uri":"http://harris.partners/","url":"/"}}]}
//              """
//
//    var content = Array[String]()
//
//
//    content = content :+ row

    val entries = parse(content)

    print("end")

  }







}
