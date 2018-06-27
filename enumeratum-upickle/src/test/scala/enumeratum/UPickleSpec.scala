package enumeratum

import org.scalatest._
import upickle.Js
import upickle.default._

/**
  * Created by Lloyd on 12/12/15.
  */
class UPickleSpec extends FunSpec with Matchers {

  import Dummy._

  describe("Reader") {

    it("should work with valid values") {
      read[Dummy](Js.Str("A")) shouldBe A
    }

    it("should fail with invalid values") {
      intercept[Exception] {
        read[Dummy](Js.Str("D"))
      }
      intercept[Exception] {
        read[Dummy](Js.Num(2))
      }
    }

  }

  describe("Writer") {

    it("should write enum values to JsString") {
      writeJs(A.asInstanceOf[Dummy]) shouldBe Js.Str("A")
    }

  }

}
