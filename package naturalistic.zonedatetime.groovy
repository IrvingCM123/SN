package naturalistic.lang

import java.time.{ZonedDateTime, ZoneId, Duration}
import naturalistic.lang.annotations._


@Noun(name = "ZonedDateTime", plural = "ZonedDateTimes")
class ZonedDateTimeThing extends naturalistic.lang.Thing {
  
  private var contained: ZonedDateTime = ZonedDateTime.now()
  
  def setContained(value: ZonedDateTime): Unit = { this.contained = value }
  
  def getContained: ZonedDateTime = contained
  
  def value: ZonedDateTimeThing = this
  
  def value_=(dateTime: ZonedDateTimeThing): Unit = { this.contained = dateTime.contained }


  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "ZonedDateTime")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[ZonedDateTimeThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained.isEqual(thing.asInstanceOf[ZonedDateTimeThing].contained))
  }
  

  @Verb(name = "before", preposition = "than", signature = "itself before than ZonedDateTime", returnType = "naturalistic.lang.Boolean", container = "ZonedDateTime")
  def itself_before_than_arg(arg0: ZonedDateTimeThing): naturalistic.lang.Boolean = {
    naturalistic.lang.Boolean.instance(this.contained.isBefore(arg0.contained))
  }


  @Verb(name = "after", preposition = "than", signature = "itself after than ZonedDateTime", returnType = "naturalistic.lang.Boolean", container = "ZonedDateTime")
  def itself_after_than_arg(arg0: ZonedDateTimeThing): naturalistic.lang.Boolean = {
    naturalistic.lang.Boolean.instance(this.contained.isAfter(arg0.contained))
  }
  

  @Verb(name = "plus", preposition = "duration", signature = "plus duration to itself", returnType = "ZonedDateTime", container = "ZonedDateTime")
  def plus_duration_to_itself(arg0: naturalistic.lang.Duration): ZonedDateTimeThing = {
    val duration: Duration = Duration.parse(arg0.toString)
    val newDateTime = this.contained.plus(duration)
    val instance = new ZonedDateTimeThing()
    instance.setContained(newDateTime)
    instance
  }

 
  @Verb(name = "minus", preposition = "duration", signature = "minus duration from itself", returnType = "ZonedDateTime", container = "ZonedDateTime")
  def minus_duration_from_itself(arg0: naturalistic.lang.Duration): ZonedDateTimeThing = {
    val duration: Duration = Duration.parse(arg0.toString)
    val newDateTime = this.contained.minus(duration)
    val instance = new ZonedDateTimeThing()
    instance.setContained(newDateTime)
    instance
  }
  

  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "ZonedDateTime")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }


  @Verb(name = "with", preposition = "time zone", signature = "with time zone", returnType = "ZonedDateTime", container = "ZonedDateTime")
  def with_time_zone_arg(arg0: naturalistic.lang.String): ZonedDateTimeThing = {
    val zone: ZoneId = ZoneId.of(arg0.getContained)
    val newDateTime = this.contained.withZoneSameInstant(zone)
    val instance = new ZonedDateTimeThing()
    instance.setContained(newDateTime)
    instance
  }
}

object ZonedDateTimeThing {

  def instance(dateTime: ZonedDateTime): ZonedDateTimeThing = {
    val instance = new ZonedDateTimeThing()
    instance.setContained(dateTime)
    instance
  }
}
