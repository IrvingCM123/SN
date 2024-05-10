package naturalistic.lang

import java.nio.{Buffer, BufferOverflowException, BufferUnderflowException}
import naturalistic.lang.annotations._


@Noun(name = "Buffer", plural = "Buffers")
class BufferThing extends naturalistic.lang.Thing {
  
  private var contained: Buffer = null
  
  def setContained(value: Buffer): Unit = { this.contained = value }
  
  def getContained: Buffer = contained
  
  def value: BufferThing = this
  
  def value_=(buffer: BufferThing): Unit = { this.contained = buffer.contained }


  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "Buffer")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[BufferThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained.equals(thing.asInstanceOf[BufferThing].contained))
  }
  
  
  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "Buffer")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }


  @Verb(name = "clear", signature = "clear itself", returnType = "Buffer", container = "Buffer")
  def clear_itself: BufferThing = {
    this.contained.clear()
    this
  }

 
  @Verb(name = "rewind", signature = "rewind itself", returnType = "Buffer", container = "Buffer")
  def rewind_itself: BufferThing = {
    this.contained.rewind()
    this
  }


  @Verb(name = "mark", signature = "mark itself", returnType = "Buffer", container = "Buffer")
  def mark_itself: BufferThing = {
    this.contained.mark()
    this
  }

  
  @Verb(name = "reset", signature = "reset itself", returnType = "Buffer", container = "Buffer")
  def reset_itself: BufferThing = {
    this.contained.reset()
    this
  }


  @Verb(name = "hasRemaining", signature = "check if it has remaining elements", returnType = "Boolean", container = "Buffer")
  def hasRemaining: naturalistic.lang.Boolean = {
    naturalistic.lang.Boolean.instance(this.contained.hasRemaining())
  }


  @Verb(name = "capacity", signature = "get capacity of itself", returnType = "Integer", container = "Buffer")
  def capacity: naturalistic.lang.Integer = {
    naturalistic.lang.Integer.instance(this.contained.capacity())
  }


  @Verb(name = "limit", signature = "get limit of itself", returnType = "Integer", container = "Buffer")
  def limit: naturalistic.lang.Integer = {
    naturalistic.lang.Integer.instance(this.contained.limit())
  }

 
  @Verb(name = "position", signature = "get position of itself", returnType = "Integer", container = "Buffer")
  def position: naturalistic.lang.Integer = {
    naturalistic.lang.Integer.instance(this.contained.position())
  }


  @Verb(name = "setPosition", preposition = "to", signature = "set position to a specific value", returnType = "Buffer", container = "Buffer")
  def setPosition_to_arg(arg0: naturalistic.lang.Integer): BufferThing = {
    this.contained.position(arg0.value.getContained.intValue())
    this
  }


  @Verb(name = "get", preposition = "element at", signature = "get element at current position", returnType = "Object", container = "Buffer")
  def get_element_at_current_position: naturalistic.lang.Object = {
    naturalistic.lang.Object.instance(this.contained.get())
  }


  @Verb(name = "get", preposition = "element at", signature = "get element at specific position", returnType = "Object", container = "Buffer")
  def get_element_at_specific_position(arg0: naturalistic.lang.Integer): naturalistic.lang.Object = {
    naturalistic.lang.Object.instance(this.contained.get(arg0.value.getContained.intValue()))
  }


  @Verb(name = "put", preposition = "element at", signature = "put element at current position", returnType = "Buffer", container = "Buffer")
  def put_element_at_current_position(arg0: naturalistic.lang.Object): BufferThing = {
    this.contained.put(arg0.getContained)
    this
  }


  @Verb(name = "put", preposition = "element at", signature = "put element at specific position", returnType = "Buffer", container = "Buffer")
  def put_element_at_specific_position(arg0: naturalistic.lang.Integer, arg1: naturalistic.lang.Object): BufferThing = {
    this.contained.put(arg0.value.getContained.intValue(), arg1.getContained)
    this
  }

  //
