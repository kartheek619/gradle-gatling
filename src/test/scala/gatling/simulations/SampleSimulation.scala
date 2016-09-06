package gatling.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SampleSimulation extends Simulation {
  val httpProtocol = http
    .baseURL("http://www.google.com")

  val scn = scenario("foo load test")
    .exec(http("Google").get("/"))

  setUp(
    scn.inject(
      atOnceUsers(1)
    )
  ).protocols(httpProtocol)
}
