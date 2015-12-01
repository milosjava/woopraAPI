package partners.harris.dataBridge

/**
  * Created by sensei on 25.11.15..
  */

import io.prediction.{Event, EventClient}

import scala.io.Source

object LoadData {


  def sendToEventServer(userId: String, itemId: String, client: EventClient) = {

    val viewEvent = new Event().event("view").entityType("user").entityId(userId).targetEntityType("item")
      .targetEntityId(itemId)

    client.createEvent(viewEvent);

  }


  def main(args: Array[String]) {

    val csvFile = args(0)
    val appKey = args(0)
    val url = args(0)

    //load csv file
    //val csvFile = "dataSet.csv"

    //val client = new EventClient("1lKeD1zfnKJ2sbkSvG4RgWiFkzEmTuYpoh7hXyDIkGrOOOaLHPfwLiTX8tIvoGcS", "http://localhost:7070")

    val client = new EventClient(appKey, url)

    val bufferedSource = Source.fromFile(csvFile)

    for (line <- bufferedSource.getLines.drop(1)) {

      val cols = line.split(",").map(_.trim)

      if(cols(1).length > 1 & cols(3).length>1) sendToEventServer(cols(1),cols(3), client)
    }

    bufferedSource.close

  }

}