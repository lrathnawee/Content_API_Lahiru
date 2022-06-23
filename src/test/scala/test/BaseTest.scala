package test

import com.typesafe.config._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BaseTest(val configName: String) extends Simulation {
  val domain = "dcm-content-api-perf.aws.wiley.com:8080/";
  val httpProtocol = http.baseUrl("http://" + domain);

  val config = ConfigFactory.load("properties.conf").getConfig(configName)

  def rampDurationLong: Int = getProperty("ramp_duration_long", "1").toInt
  def rampDurationShort: Int = getProperty("ramp_duration_short", "1").toInt
  val testDuration: Int = getProperty("duration", "1").toInt

  def getProperty(propertyName: String, defaultValue: String) = {
    Option(System.getenv(propertyName))
      .orElse(Option(System.getProperty(propertyName)))
      .getOrElse(defaultValue)
  }

  def getUsers(path: String) = getConfProperty(path, "users")
  def getPace(path: String) = getConfProperty(path, "pace")

  def getConfProperty(path: String, property: String): Int = {
    config.getConfig(path).getInt(property)
  }
}
