import play.api.libs.json._

import play.api.libs.functional.syntax._

import java.util.Date

case class Visitor(continent: String, date: String, country: String,city : String, pid: String)


implicit val documentReader: Reads[Visitor] = (
  (__ \ "continent").read[String] and
    (__ \ "country").read[String] and
    (__ \ "date").read[String] and
    (__ \ "city").read[String] and
    (__ \ "pid").read[String]
  ) (Visitor.apply _)



val jsonString = """{"continent":"OC","date":"2015-11-16","country":"AU","city":"Sydney","timezone":"Australia/Sydney","screen":"375x667","description":"","language":"English","pid":"teI53ztajO7N","type":"visit","resolution":"375x667","second":28,"duration":133,"number":1,"post":"1001","browser":"Safari Mobile","lat":-33.8615,"hour_of_day":19,"os":"iPhone IOS9","lng":151.2055,"offset":"+10:00","method":"","org":"","ip":"27.124.102.30","h":"teI53ztajO7N","minute":38,"referrer":{"query":"-encrypted-","type":"search","url":"https://www.google.com.au/"},"time":1447663108163,"region":"New South Wales","visitor":{"first_referrer_query":"-encrypted-","fingerprint":"3076239903","first_referrer_url":"https://www.google.com.au/","first_visit_time":"1447663108201","first_referrer_type":"search"},"device":"mobile","actions":[{"duration":133,"date":"7:38:28 PM","exit":true,"landing":true,"domain":"harris.partners","name":"pv","time":1447663108163,"properties":{"domain":"harris.partners","name":"pv","dn":"133","title":"\n\nHarris Partners | Home Page | We are revolutionising customer engagement through digital &amp; big data.","uri":"http://harris.partners/","url":"/"}}]}
                   """

Json.parse(jsonString).as[Visitor]

