package acuario

interface FuncionesExtra {
    fun tomarFoto()
}

abstract class DispositivoMovil(val marca: String) {
    abstract val esGamaAlta: Boolean
}

open class Celular(marca: String, open var almacenamiento: Int = 64) : DispositivoMovil(marca), FuncionesExtra {

    override val esGamaAlta = false

    var cargaBateria: Int = 50
        get() = field
        set(valor) {
            field = if (valor in 0..100) valor else 100
        }

    override fun tomarFoto() {
        println("El celular $marca toma una foto estándar")
    }

    fun mostrarEstado() {
        println("Celular $marca con $almacenamiento GB y $cargaBateria% de batería")
    }
}

class Iphone(marca: String) : Celular(marca, almacenamiento = 128) {

    override val esGamaAlta = true

    override fun tomarFoto() {
        println("El $marca activa el modo cine y toma una foto profesional")
    }
}

fun probarCelulares() {
    val miBasico = Celular("Nokia")
    val miPro = Iphone("Apple")

    miBasico.cargaBateria = 80
    miBasico.mostrarEstado()
    miBasico.tomarFoto()

    miPro.cargaBateria = 150 // El setter lo bajará a 100 automáticamente
    miPro.mostrarEstado()
    miPro.tomarFoto()
}