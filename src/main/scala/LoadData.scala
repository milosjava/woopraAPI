/**
  * Created by sensei on 25.11.15..
  */

import io.prediction.Event
import io.prediction.EventClient
import scala.io.Source

object LoadData {



  val client = new EventClient("1lKeD1zfnKJ2sbkSvG4RgWiFkzEmTuYpoh7hXyDIkGrOOOaLHPfwLiTX8tIvoGcS", "http://localhost:7070")


  def sendToEventServer(userId: String, itemId: String) = {

    val buyEvent = new Event().event("buy").entityType("user").entityId(userId).targetEntityType("item")
      .targetEntityId(itemId)

    client.createEvent(buyEvent);

  }



  def main(args: Array[String]) {

    //load csv file
    val csvFile = "dataSet.csv"


    val bufferedSource = Source.fromURL(getClass.getResource(csvFile))

    for (line <- bufferedSource.getLines.drop(1)) {

      val cols = line.split(",").map(_.trim)

      if(cols(1).length > 1 & cols(3).length>1) sendToEventServer(cols(1),cols(3))
    }

    bufferedSource.close

  }





}
