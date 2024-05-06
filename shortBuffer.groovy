package naturalistic.lang

import java.nio.{ShortBuffer}
import naturalistic.lang.annotations._

// Clase que representa un buffer de cortos (shorts) con funcionalidades adicionales.
@Noun(name = "ShortBuffer", plural = "ShortBuffers")
class ShortBufferThing extends naturalistic.lang.Thing {
  
  // Variable privada que almacena el buffer de tipo ShortBuffer.
  private var contained: ShortBuffer = ShortBuffer.allocate(0)
  
  // Método para establecer el buffer de cortos.
  def setContained(value: ShortBuffer): Unit = { this.contained = value }
  
  // Método para obtener el buffer de cortos actual.
  def getContained: ShortBuffer = contained
  
  // Devuelve la instancia actual de ShortBufferThing.
  def value: ShortBufferThing = this
  
  // Actualiza el buffer usando otra instancia de ShortBufferThing.
  def value_=(buffer: ShortBufferThing): Unit = { this.contained = buffer.contained }

  // Compara si esta instancia es igual a otra instancia de ShortBufferThing.
  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "ShortBuffer")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[ShortBufferThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained.equals(thing.asInstanceOf[ShortBufferThing].contained))
  }
  
  // Devuelve la representación en cadena del buffer de cortos.
  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "ShortBuffer")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }
}

// Objeto complementario para crear instancias de ShortBufferThing con un ShortBuffer específico.
object ShortBufferThing {
  def instance(buffer: ShortBuffer): ShortBufferThing = {
    val instance = new ShortBufferThing()
    instance.setContained(buffer)
    instance
  }
}
