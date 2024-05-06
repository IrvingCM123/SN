

package naturalistic.lang

import java.nio.{LongBuffer}
import naturalistic.lang.annotations._


@Noun(name = "LongBuffer", plural = "LongBuffers")
class LongBufferThing extends naturalistic.lang.Thing {
  
  private var contained: LongBuffer = LongBuffer.allocate(0)
  
  def setContained(value: LongBuffer): Unit = { this.contained = value }
  
  def getContained: LongBuffer = contained
  
  def value: LongBufferThing = this
  
  def value_=(buffer: LongBufferThing): Unit = { this.contained = buffer.contained }

  
  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "LongBuffer")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[LongBufferThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained.equals(thing.asInstanceOf[LongBufferThing].contained))
  }
  

  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "LongBuffer")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }
}

object LongBufferThing {
  def instance(buffer: LongBuffer): LongBufferThing = {
    val instance = new LongBufferThing()
    instance.setContained(buffer)
    instance
  }
}
