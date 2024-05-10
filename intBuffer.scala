intBuffer.groovy

package naturalistic.lang

import java.nio.{IntBuffer}
import naturalistic.lang.annotations._

// Clase que representa un buffer de enteros con funcionalidades adicionales.
@Noun(name = "IntBuffer", plural = "IntBuffers")
class IntBufferThing extends naturalistic.lang.Thing {
  
    // Variable privada que almacena el buffer de tipo IntBuffer.
  private var contained: IntBuffer = IntBuffer.allocate(0)
  
    // Método para establecer el buffer de enteros.
  def setContained(value: IntBuffer): Unit = { this.contained = value }
  
  // Método para obtener el buffer de enteros actual.
  def getContained: IntBuffer = contained

  // Devuelve la instancia actual de IntBufferThing.
  def value: IntBufferThing = this
  
    // Actualiza el buffer usando otra instancia de IntBufferThing.
  def value_=(buffer: IntBufferThing): Unit = { this.contained = buffer.contained }

  // Compara si esta instancia es igual a otra instancia de IntBufferThing.
  @Verb(name = "equal", preposition = "to", signature = "itself equal to Thing", returnType = "naturalistic.lang.Boolean", container = "IntBuffer")
  override def itself_equal_to_arg(thing: naturalistic.lang.Concept): naturalistic.lang.Boolean = {
    if (!thing.isInstanceOf[IntBufferThing]) { return naturalistic.lang.Boolean.instance(false) }
    naturalistic.lang.Boolean.instance(this.contained.equals(thing.asInstanceOf[IntBufferThing].contained))
  }
  
  // Devuelve la representación en cadena del buffer de enteros.
  @Verb(name = "toString", signature = "toString of itself", returnType = "String", container = "IntBuffer")
  override def string_of_itself: naturalistic.lang.String = {
    naturalistic.lang.String.instance(this.contained.toString)
  }
}

// Objeto complementario para crear instancias de IntBufferThing con un IntBuffer específico.
object IntBufferThing {
  def instance(buffer: IntBuffer): IntBufferThing = {
    val instance = new IntBufferThing()
    instance.setContained(buffer)
    instance
  }
}
