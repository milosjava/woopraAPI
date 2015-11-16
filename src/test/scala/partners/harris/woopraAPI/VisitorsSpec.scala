package partners.harris.woopraAPI

import org.scalatest.FunSuite

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/16/15.
  */
class VisitorsSpec extends FunSuite{

  test("loading file"){

    val content = Visitors.readFile("two-days-ago.log")

    assert(content.size == 11)


  }

}
