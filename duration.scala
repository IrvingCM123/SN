package naturalistic.lang

import java.time.Duration
import naturalistic.lang.annotations._

// Clase que encapsula un objeto Duration para manejar duraciones de tiempo.
@Noun(name = "Duration", plural = "Durations")
class DurationThing extends naturalistic.lang.Thing {
  
  // Variable privada que contiene la duración.
  private var contained: Duration = Duration.ZERO
  
  // Método para establecer la duración.
  def setContained(value: Duration): Unit = { this.contained = value }
  
  // Método para obtener la duración actual.
  def getContained: Duration = contained
  
   // Devuelve la instancia actual de DurationThing.
  def value: DurationThing = this
  
  // Establece la duración usando otra instancia de DurationThing.
  def value_=(duration: DurationThing): Unit = { this.contained = duration.contained }

  // Compara si esta instancia es igual a otra instancia de DurationThing.
  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "Duration")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[DurationThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained.equals(thing.asInstanceOf[DurationThing].contained))
  }
  
  // Añade la duración de otra instancia de DurationThing a la duración actual.
  @Verb(name = "plus", preposition = "duration", signature = "plus duration to itself", returnType = "Duration", container = "Duration")
  def plus_duration_to_itself(arg0: DurationThing): DurationThing = {
    val newDuration = this.contained.plus(arg0.contained)
    val instance = new DurationThing()
    instance.setContained(newDuration)
    instance
  }

  // Resta la duración de otra instancia de DurationThing de la duración actual.
  @Verb(name = "minus", preposition = "duration", signature = "minus duration from itself", returnType = "Duration", container = "Duration")
  def minus_duration_from_itself(arg0: DurationThing): DurationThing = {
    val newDuration = this.contained.minus(arg0.contained)
    val instance = new DurationThing()
    instance.setContained(newDuration)
    instance
  }
  
  // Devuelve la representación en cadena de la duración contenida.
  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "Duration")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }
}

// Objeto complementario para crear instancias de DurationThing con una duración específica.
object DurationThing {
  def instance(duration: Duration): DurationThing = {
    val instance = new DurationThing()
    instance.setContained(duration)
    instance
  }
}
