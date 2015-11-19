package partners.harris.woopraAPI

import org.scalatest.FunSuite

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/16/15.
  */
class VisitorsSpec extends FunSuite{

  test("loading json from file"){

    val content = Visitors.readFile("two-days-ago.log")

    assert(content.size == 11)

  }


  test("parse json "){


    //test data for parsing
    val row = """{"continent":"EU","date":"2015-11-18","country":"RS","city":"Pančevo","timezone":"Europe/Belgrade","screen":"1920x1080","description":"","language":"English","pid":"ggTQYfnwkMYG","type":"visit","resolution":"1920x1080","second":0,"duration":444,"number":5,"post":"","browser":"Chrome","lat":44.8708,"hour_of_day":2,"os":"Linux","lng":20.6403,"offset":"+01:00","method":"","org":"","ip":"89.216.152.115","h":"ggTQYfnwkMYG","minute":21,"referrer":{"query":"","type":"direct","url":""},"time":1447773660085,"region":"Vojvodina","visitor":{"name":"Milos","fingerprint":"2798630358","first_visit_time":"1447678760470","first_referrer_type":"direct"},"device":"desktop","actions":[{"duration":432,"date":"2:21:12 AM","domain":"harris.partners","name":"wp article","time":1447773672068,"properties":{"author":"Tim Doyle","name":"wp article","dn":"432","permalink":"http://harris.partners/the-challenge-of-owning-moments/","title":"The challenge of owning moments","category":"Blog","post date":"1443532696000"}},{"duration":10,"date":"2:21:04 AM","exit":true,"domain":"harris.partners","name":"pv","time":1447773664139,"properties":{"domain":"harris.partners","name":"pv","dn":"10","title":"\n\nThought Leadership - Harris Partners | We are revolutionising customer engagement through digital &amp; big data.","uri":"http://harris.partners/thought-leadership/","url":"/thought-leadership/"}},{"duration":10,"date":"2:21:00 AM","landing":true,"domain":"harris.partners","name":"pv","time":1447773660085,"properties":{"domain":"harris.partners","name":"pv","dn":"10","title":"\n\nHarris Partners | Home Page | We are revolutionising customer engagement through digital &amp; big data.","uri":"http://harris.partners/","url":"/"}}]}
              """

    var content = Array[String]()


    content = content :+ row

    val entries = Visitors.parse(content)

    //check if it returns one
    assert(entries.length == 1)

    //check name is Milos
    assert(entries(0).name == "Milos")

    //TODO pid wil be probably removed
    //check pid is ggTQYfnwkMYG
    assert(entries(0).pid == "ggTQYfnwkMYG")

    //check fingerprint is 2798630358
    assert(entries(0).fingerprint == "2798630358")

    val actions = entries(0).actions

    assert(actions.length == 3)



  }

}
