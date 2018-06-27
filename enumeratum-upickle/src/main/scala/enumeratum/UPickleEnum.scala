package enumeratum

import upickle.default.{ReadWriter => RW, _}

/**
  * Enum mix-in with default Reader and Writers defined (case sensitive)
  */
trait UPickleEnum[A <: EnumEntry] { self: Enum[A] =>

  implicit val uPickleReadWriter: RW[A] = readwriter[String].bimap[A](
    x => x.entryName,
    str => this.withName(str)
  );

}
