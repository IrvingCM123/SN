
package naturalistic.lang

import java.time.{LocalDateTime, Duration}
import naturalistic.lang.annotations._

// Definición de la clase LocalDateTimeThing, marcada con la anotación @Noun para uso en un contexto naturalista
@Noun(name = "LocalDateTime", plural = "LocalDateTimes")
class LocalDateTimeThing extends naturalistic.lang.Thing {

  // Variable privada que almacena el objeto LocalDateTime
  private var contained: LocalDateTime = LocalDateTime.now()
  
  // Método setter para actualizar la variable 'contained'
  def setContained(value: LocalDateTime): Unit = { this.contained = value }
  
  // Método getter para obtener el valor de 'contained'
  def getContained: LocalDateTime = contained
  
  // Método para obtener la instancia actual de LocalDateTimeThing
  def value: LocalDateTimeThing = this
  
  // Método setter para actualizar 'contained' usando otra instancia de LocalDateTimeThing
  def value_=(dateTime: LocalDateTimeThing): Unit = { this.contained = dateTime.contained }

  // Método anotado con @Verb para definir una operación de igualdad
  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "LocalDateTime")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[LocalDateTimeThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained.isEqual(thing.asInstanceOf[LocalDateTimeThing].contained))
  }
  
  // Método anotado con @Verb para determinar si la instancia actual es anterior a otra instancia de LocalDateTimeThing
  @Verb(name = "before", preposition = "than", signature = "itself before than LocalDateTime", returnType = "naturalistic.lang.Boolean", container = "LocalDateTime")
  def itself_before_than_arg(arg0: LocalDateTimeThing): naturalistic.lang.Boolean = {
    naturalistic.lang.Boolean.instance(this.contained.isBefore(arg0.contained))
  }

  // Método anotado con @Verb para determinar si la instancia actual es posterior a otra instancia de LocalDateTimeThing
  @Verb(name = "after", preposition = "than", signature = "itself after than LocalDateTime", returnType = "naturalistic.lang.Boolean", container = "LocalDateTime")
  def itself_after_than_arg(arg0: LocalDateTimeThing): naturalistic.lang.Boolean = {
    naturalistic.lang.Boolean.instance(this.contained.isAfter(arg0.contained))
  }
  
  // Método anotado con @Verb para añadir una duración al tiempo actual
  @Verb(name = "plus", preposition = "duration", signature = "plus duration to itself", returnType = "LocalDateTime", container = "LocalDateTime")
  def plus_duration_to_itself(arg0: naturalistic.lang.Duration): LocalDateTimeThing = {
    val duration: Duration = Duration.parse(arg0.toString)
    val newDateTime = this.contained.plus(duration)
    val instance = new LocalDateTimeThing()
    instance.setContained(newDateTime)
    instance
  }

  // Método anotado con @Verb para restar una duración del tiempo actual
  @Verb(name = "minus", preposition = "duration", signature = "minus duration from itself", returnType = "LocalDateTime", container = "LocalDateTime")
  def minus_duration_from_itself(arg0: naturalistic.lang.Duration): LocalDateTimeThing = {
    val duration: Duration = Duration.parse(arg0.toString)
    val newDateTime = this.contained.minus(duration)
    val instance = new LocalDateTimeThing()
    instance.setContained(newDateTime)
    instance
  }

  // Método anotado con @Verb para obtener una representación en forma de cadena de la fecha y hora actual
  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "LocalDateTime")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }
}

// Objeto compañero para facilitar la creación de instancias de LocalDateTimeThing
object LocalDateTimeThing {
  def instance(dateTime: LocalDateTime): LocalDateTimeThing = {
    val instance = new LocalDateTimeThing()
    instance.setContained(dateTime)
    instance
  }
}
