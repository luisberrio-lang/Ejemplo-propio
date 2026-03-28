package acuario

interface AccionMoto {
    fun hacerCaballito()
}

abstract class VehiculoDosRuedas(val marca: String) {
    abstract val requiereCascoIntegral: Boolean
}

open class Moto(marca: String, open var cilindrada: Int = 125) : VehiculoDosRuedas(marca), AccionMoto {

    override val requiereCascoIntegral = true

    var velocidadActual: Int = 0
        get() = field
        set(valor) {
            field = if (valor in 0..180) valor else 180
        }

    override fun hacerCaballito() {
        println("La moto $marca levanta la rueda delantera")
    }

    fun mostrarInfo() {
        println("Moto $marca de $cilindrada cc a $velocidadActual km/h")
    }
}

class MotoPista(marca: String) : Moto(marca, cilindrada = 1000) {

    override fun hacerCaballito() {
        println("La moto de pista $marca hace un caballito a alta velocidad")
    }
}

fun probarMotos() {
    val miScooter = Moto("Honda")
    val miNinja = MotoPista("Kawasaki")

    miScooter.velocidadActual = 100
    miScooter.mostrarInfo()
    miScooter.hacerCaballito()

    miNinja.velocidadActual = 300
    miNinja.mostrarInfo()
    miNinja.hacerCaballito()
}