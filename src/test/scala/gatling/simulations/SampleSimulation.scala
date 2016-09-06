package gatling.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SampleSimulation extends Simulation {
  val httpProtocol = http
    .baseURL("http://www.google.com")    //Replace google url with url you want to test

  val scn = scenario("Google Load test")
    .exec(http("Google").get("/"))      //Replace / with the path that you want to test

  setUp(
    scn.inject(
      atOnceUsers(1)
    )
  ).protocols(httpProtocol)
}
