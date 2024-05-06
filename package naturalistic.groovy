package naturalistic.lang

import java.time.{Period}
import naturalistic.lang.annotations._

// Clase que representa un periodo con utilidades para gestionarlo.
@Noun(name = "Period", plural = "Periods")
class PeriodThing extends naturalistic.lang.Thing {
  
    // Variable para almacenar el periodo.
  private var contained: Period = Period.ZERO
  
  // Establece el valor del periodo.
  def setContained(value: Period): Unit = { this.contained = value }
  
  // Obtiene el valor del periodo almacenado.
  def getContained: Period = contained
  
  // Devuelve la instancia actual de PeriodThing.
  def value: PeriodThing = this
  
  // Establece el periodo a partir de otra instancia de PeriodThing.
  def value_=(period: PeriodThing): Unit = { this.contained = period.contained }
  
    // Metodo para comparar si esta instancia es igual a otra instancia de Concept.
  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "Period")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[PeriodThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained == thing.asInstanceOf[PeriodThing].contained)
  }

  // Suma el periodo de otra instancia de PeriodThing al periodo actual.
  @Verb(name = "plus", preposition = "period", signature = "plus period to itself", returnType = "Period", container = "Period")
  def plus_period_to_itself(arg0: PeriodThing): PeriodThing = {
    val newPeriod = this.contained.plus(arg0.contained)
    val instance = new PeriodThing()
    instance.setContained(newPeriod)
    instance
  }

  // Resta el periodo de otra instancia de PeriodThing del periodo actual.
  @Verb(name = "minus", preposition = "period", signature = "minus period from itself", returnType = "Period", container = "Period")
  def minus_period_from_itself(arg0: PeriodThing): PeriodThing = {
    val newPeriod = this.contained.minus(arg0.contained)
    val instance = new PeriodThing()
    instance.setContained(newPeriod)
    instance
  }

  // Obtiene los años del período.
  @Verb(name = "getYears", signature = "get years of itself", returnType = "Integer", container = "Period")
  def getYears: naturalistic.lang.Number with naturalistic.lang.NumberProperty = {
    naturalistic.lang.Number.instance(this.contained.getYears)
  }

  // Obtiene los meses del período.
  @Verb(name = "getMonths", signature = "get months of itself", returnType = "Integer", container = "Period")
  def getMonths: naturalistic.lang.Number with naturalistic.lang.NumberProperty = {
    naturalistic.lang.Number.instance(this.contained.getMonths)
  }
  // Obtiene los días del período.
  @Verb(name = "getDays", signature = "get days of itself", returnType = "Integer", container = "Period")
  def getDays: naturalistic.lang.Number with naturalistic.lang.NumberProperty = {
    naturalistic.lang.Number.instance(this.contained.getDays)
  }

  // Devuelve la representación en cadena del período.
  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "Period")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }

}

// Objeto complementario para crear instancias de PeriodThing con un período específico.
object PeriodThing {
  def instance(period: Period): PeriodThing = {
    val instance = new PeriodThing()
    instance.setContained(period)
    instance
  }
}
