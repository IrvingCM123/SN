package naturalistic.lang

import java.math.{BigInteger}
import naturalistic.lang.annotations._


@Noun(name = "BigInteger", plural = "BigIntegers")
class BigIntegerThing extends naturalistic.lang.Thing {
  
  private var contained: BigInteger = BigInteger.ZERO
  
  def setContained(value: BigInteger): Unit = { this.contained = value }
  
  def getContained: BigInteger = contained
  
  def value: BigIntegerThing = this
  
  def value_=(integer: BigIntegerThing): Unit = { this.contained = integer.contained }


  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "BigInteger")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[BigIntegerThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained.equals(thing.asInstanceOf[BigIntegerThing].contained))
  }
  

  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "BigInteger")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }


  @Verb(name = "plus", preposition = "to", signature = "add itself to another BigInteger", returnType = "BigInteger", container = "BigInteger")
  def plus_arg_to_itself(arg0: BigIntegerThing): BigIntegerThing = {
    val result = this.contained.add(arg0.contained)
    BigIntegerThing.instance(result)
  }

 
  @Verb(name = "minus", preposition = "from", signature = "subtract another BigInteger from itself", returnType = "BigInteger", container = "BigInteger")
  def minus_arg_from_itself(arg0: BigIntegerThing): BigIntegerThing = {
    val result = this.contained.subtract(arg0.contained)
    BigIntegerThing.instance(result)
  }


  @Verb(name = "multiply", preposition = "by", signature = "multiply itself by another BigInteger", returnType = "BigInteger", container = "BigInteger")
  def multiply_by_arg(arg0: BigIntegerThing): BigIntegerThing = {
    val result = this.contained.multiply(arg0.contained)
    BigIntegerThing.instance(result)
  }

  @Verb(name = "divide", preposition = "by", signature = "divide itself by another BigInteger", returnType = "BigInteger", container = "BigInteger")
  def divide_by_arg(arg0: BigIntegerThing): BigIntegerThing = {
    val result = this.contained.divide(arg0.contained)
    BigIntegerThing.instance(result)
  }


  @Verb(name = "remainder", preposition = "by", signature = "get the remainder when divided by another BigInteger", returnType = "BigInteger", container = "BigInteger")
  def remainder_by_arg(arg0: BigIntegerThing): BigIntegerThing = {
    val result = this.contained.remainder(arg0.contained)
    BigIntegerThing.instance(result)
  }


  @Verb(name = "pow", signature = "raise itself to the power of another BigInteger", returnType = "BigInteger", container = "BigInteger")
  def pow_arg(arg0: BigIntegerThing): BigIntegerThing = {
    val result = this.contained.pow(arg0.contained.intValue())
    BigIntegerThing.instance(result)
  }


  @Verb(name = "abs", signature = "get the absolute value of itself", returnType = "BigInteger", container = "BigInteger")
  def abs_of_itself: BigIntegerThing = {
    val result = this.contained.abs()
    BigIntegerThing.instance(result)
  }
}

object BigIntegerThing {
  def instance(integer: BigInteger): BigIntegerThing = {
    val instance = new BigIntegerThing()
    instance.setContained(integer)
    instance
  }
}
