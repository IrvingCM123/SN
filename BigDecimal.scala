package naturalistic.lang

import java.math.{BigDecimal, MathContext, RoundingMode}
import naturalistic.lang.annotations._

@Noun(name = "BigDecimal", plural = "BigDecimals")
class BigDecimalThing extends naturalistic.lang.Thing {
  
  private var contained: BigDecimal = BigDecimal.ZERO
  
  def setContained(value: BigDecimal): Unit = { this.contained = value }
  
  def getContained: BigDecimal = contained
  
  def value: BigDecimalThing = this
  
  def value_=(decimal: BigDecimalThing): Unit = { this.contained = decimal.contained }


  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "BigDecimal")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[BigDecimalThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained.equals(thing.asInstanceOf[BigDecimalThing].contained))
  }
  

  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "BigDecimal")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }


  @Verb(name = "round", preposition = "to", signature = "round itself to a specific number of decimal places", returnType = "BigDecimal", container = "BigDecimal")
  def round_to_decimals(arg0: naturalistic.lang.Integer): BigDecimalThing = {
    val scale = arg0.value.getContained.intValue()
    val rounded = this.contained.setScale(scale, RoundingMode.HALF_UP)
    BigDecimalThing.instance(rounded)
  }


  @Verb(name = "plus", preposition = "to", signature = "add itself to another BigDecimal", returnType = "BigDecimal", container = "BigDecimal")
  def plus_arg_to_itself(arg0: BigDecimalThing): BigDecimalThing = {
    val result = this.contained.add(arg0.contained)
    BigDecimalThing.instance(result)
  }

  @Verb(name = "minus", preposition = "from", signature = "subtract another BigDecimal from itself", returnType = "BigDecimal", container = "BigDecimal")
  def minus_arg_from_itself(arg0: BigDecimalThing): BigDecimalThing = {
    val result = this.contained.subtract(arg0.contained)
    BigDecimalThing.instance(result)
  }


  @Verb(name = "multiply", preposition = "by", signature = "multiply itself by another BigDecimal", returnType = "BigDecimal", container = "BigDecimal")
  def multiply_by_arg(arg0: BigDecimalThing): BigDecimalThing = {
    val result = this.contained.multiply(arg0.contained)
    BigDecimalThing.instance(result)
  }

  @Verb(name = "divide", preposition = "by", signature = "divide itself by another BigDecimal", returnType = "BigDecimal", container = "BigDecimal")
  def divide_by_arg(arg0: BigDecimalThing): BigDecimalThing = {
    val result = this.contained.divide(arg0.contained, MathContext.DECIMAL128)
    BigDecimalThing.instance(result)
  }


  @Verb(name = "abs", signature = "get the absolute value of itself", returnType = "BigDecimal", container = "BigDecimal")
  def abs_of_itself: BigDecimalThing = {
    val result = this.contained.abs()
    BigDecimalThing.instance(result)
  }
}

object BigDecimalThing {
  def instance(decimal: BigDecimal): BigDecimalThing = {
    val instance = new BigDecimalThing()
    instance.setContained(decimal)
    instance
  }
}
