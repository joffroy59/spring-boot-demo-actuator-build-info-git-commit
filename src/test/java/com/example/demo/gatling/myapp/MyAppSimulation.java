package com.example.demo.gatling.myapp;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class MyAppSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
          .baseUrl("http://172.30.192.1:8080")
          .inferHtmlResources()
          .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
          .acceptEncodingHeader("gzip, deflate")
          .acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
          .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/118.0");

  private Map<CharSequence, String> headers_0 = Map.of("Upgrade-Insecure-Requests", "1");

  private Map<CharSequence, String> headers_7 = Map.of("Accept", "image/avif,image/webp,*/*");


  private ScenarioBuilder scn = scenario("com.example.demo.gatling.myapp.MyAppSimulation")
          .exec(
                  http("request_0")
                          .get("/actuator/info")
                          .headers(headers_0)
          )
          .pause(33)
          .exec(
                  http("request_1")
                          .get("/actuator/health")
                          .headers(headers_0)
          )
          .pause(3)
          .exec(
                  http("request_2")
                          .get("/actuator/info")
                          .headers(headers_0)
          )
          .pause(1)
          .exec(
                  http("request_3")
                          .get("/actuator/info")
                          .headers(headers_0)
          )
          .pause(2)
          .exec(
                  http("request_4")
                          .get("/actuator/health")
                          .headers(headers_0)
                          .resources(
                                  http("request_5")
                                          .get("/actuator/health")
                                          .headers(headers_0)
                          )
          )
          .pause(7)
          .exec(
                  http("request_6")
                          .get("/actuator/")
                          .headers(headers_0)
                          .check(status().is(404))
                          .resources(
                                  http("request_7")
                                          .get("/favicon.ico")
                                          .headers(headers_7)
                          )
          )
          .pause(11)
          .exec(
                  http("request_8")
                          .get("/management/")
                          .headers(headers_0)
                          .check(status().is(404))
          )
          .pause(5)
          .exec(
                  http("request_9")
                          .get("/enadpoint/")
                          .headers(headers_0)
                          .check(status().is(404))
          )
          .pause(13)
          .exec(
                  http("request_10")
                          .get("/actuator/")
                          .headers(headers_0)
                          .check(status().is(404))
          )
          .pause(5)
          .exec(
                  http("request_11")
                          .get("/actuator/info")
                          .headers(headers_0)
          )
          .pause(2)
          .exec(
                  http("request_12")
                          .get("/actuator/info")
                          .headers(headers_0)
                          .resources(
                                  http("request_13")
                                          .get("/actuator/info")
                                          .headers(headers_0),
                                  http("request_14")
                                          .get("/actuator/info")
                                          .headers(headers_0),
                                  http("request_15")
                                          .get("/actuator/info")
                                          .headers(headers_0),
                                  http("request_16")
                                          .get("/actuator/info")
                                          .headers(headers_0),
                                  http("request_17")
                                          .get("/actuator/info")
                                          .headers(headers_0),
                                  http("request_18")
                                          .get("/actuator/info")
                                          .headers(headers_0),
                                  http("request_19")
                                          .get("/actuator/info")
                                          .headers(headers_0),
                                  http("request_20")
                                          .get("/actuator/info")
                                          .headers(headers_0),
                                  http("request_21")
                                          .get("/actuator/info")
                                          .headers(headers_0)
                          )
          );

  {
    setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
