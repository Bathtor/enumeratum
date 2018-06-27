package enumeratum.values

import upickle.default.{ReadWriter => RW, _}

/**
  * Created by Lloyd on 4/14/16.
  *
  * Copyright 2016
  */
sealed trait UPickleValueEnum[ValueType, EntryType <: ValueEnumEntry[ValueType]] {
  this: ValueEnum[ValueType, EntryType] =>

  /**
    * Implicit UPickle ReadWriter
    */
  implicit def uPickleReadWriter: RW[EntryType]

}

/**
  * Enum implementation for Int enum members that contains an implicit UPickle ReadWriter
  */
trait IntUPickleEnum[EntryType <: IntEnumEntry] extends UPickleValueEnum[Int, EntryType] {
  this: ValueEnum[Int, EntryType] =>
  implicit val uPickleReadWriter: RW[EntryType] = readwriter[Int].bimap[EntryType](
    x => x.value,
    v => this.withValue(v)
  );
}

/**
  * Enum implementation for Long enum members that contains an implicit UPickle ReadWriter
  */
trait LongUPickleEnum[EntryType <: LongEnumEntry] extends UPickleValueEnum[Long, EntryType] {
  this: ValueEnum[Long, EntryType] =>
  implicit val uPickleReadWriter: RW[EntryType] = readwriter[Long].bimap[EntryType](
    x => x.value,
    v => this.withValue(v)
  );
}

/**
  * Enum implementation for Short enum members that contains an implicit UPickle ReadWriter
  */
trait ShortUPickleEnum[EntryType <: ShortEnumEntry] extends UPickleValueEnum[Short, EntryType] {
  this: ValueEnum[Short, EntryType] =>
  implicit val uPickleReadWriter: RW[EntryType] = readwriter[Short].bimap[EntryType](
    x => x.value,
    v => this.withValue(v)
  );
}

/**
  * Enum implementation for String enum members that contains an implicit UPickle ReadWriter
  */
trait StringUPickleEnum[EntryType <: StringEnumEntry] extends UPickleValueEnum[String, EntryType] {
  this: ValueEnum[String, EntryType] =>
  implicit val uPickleReadWriter: RW[EntryType] = readwriter[String].bimap[EntryType](
    x => x.value,
    v => this.withValue(v)
  );
}

/**
  * Enum implementation for Byte enum members that contains an implicit UPickle ReadWriter
  */
trait ByteUPickleEnum[EntryType <: ByteEnumEntry] extends UPickleValueEnum[Byte, EntryType] {
  this: ValueEnum[Byte, EntryType] =>
  implicit val uPickleReadWriter: RW[EntryType] = readwriter[Byte].bimap[EntryType](
    x => x.value,
    v => this.withValue(v)
  );
}

/**
  * Enum implementation for Char enum members that contains an implicit UPickle ReadWriter
  */
trait CharUPickleEnum[EntryType <: CharEnumEntry] extends UPickleValueEnum[Char, EntryType] {
  this: ValueEnum[Char, EntryType] =>
  implicit val uPickleReadWriter: RW[EntryType] = readwriter[Char].bimap[EntryType](
    x => x.value,
    v => this.withValue(v)
  );
}
