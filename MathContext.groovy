package naturalistic.lang

import java.math.{MathContext}
import naturalistic.lang.annotations._


@Noun(name = "MathContext", plural = "MathContexts")
class MathContextThing extends naturalistic.lang.Thing {
  
  private var contained: MathContext = MathContext.UNLIMITED
  
  def setContained(value: MathContext): Unit = { this.contained = value }
  
  def getContained: MathContext = contained
  
  def value: MathContextThing = this
  
  def value_=(context: MathContextThing): Unit = { this.contained = context.contained }

  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "MathContext")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[MathContextThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained.equals(thing.asInstanceOf[MathContextThing].contained))
  }
  

  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "MathContext")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }

  @Verb(name = "setPrecision", preposition = "to", signature = "set precision to a specific value", returnType = "MathContext", container = "MathContext")
  def setPrecision_to_arg(arg0: naturalistic.lang.Integer): MathContextThing = {
    val context = new MathContext(arg0.value.getContained.intValue())
    MathContextThing.instance(context)
  }


  @Verb(name = "setRoundingMode", preposition = "to", signature = "set rounding mode to a specific mode", returnType = "MathContext", container = "MathContext")
  def setRoundingMode_to_arg(arg0: naturalistic.lang.String): MathContextThing = {
    val mode = RoundingMode.valueOf(arg0.getContained)
    val context = new MathContext(this.contained.getPrecision, mode)
    MathContextThing.instance(context)
  }

 
  @Verb(name = "combine", preposition = "with", signature = "combine itself with another MathContext", returnType = "MathContext", container = "MathContext")
  def combine_with_arg(arg0: MathContextThing): MathContextThing = {
    val context = new MathContext(this.contained.getPrecision, this.contained.getRoundingMode.combine(arg0.contained.getRoundingMode))
    MathContextThing.instance(context)
  }
}

object MathContextThing {
  def instance(context: MathContext): MathContextThing = {
    val instance = new MathContextThing()
    instance.setContained(context)
    instance
  }
}
