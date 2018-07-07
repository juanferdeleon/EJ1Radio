/*Radio Ejercicio 1
10/07/2018
Juan Fernando De Leon Quzada
Carne
 */

package main

fun main(args: Array<String>) {

    var op: Int = 0
    var opCor: Boolean = false

    //Menu de inicio

    do {
            print("""Radio:
                1. Encender
                2. Salir
                Seleccione una opcion:
                """.trimIndent())
            val opSelec: String? = readLine()
            if (opSelec != null) {
                    try {
                            op = opSelec.toInt()
                            if (op in 1..2){
                                    opCor = true
                            }else {
                                    println("ERROR: $op NO es una opcion valida")
                            }
                    } catch (error: NumberFormatException) {
                            println("ERROR: $opSelec NO es una opcion valida")
                            opCor = false
                    }
            }
    }while (!opCor)

    //Crear Radio
    val radio = Radio(
            vol = 50,
            est = 87.50,
            recep = "F.M."
    )

    //Opciones del menu principal
    if (op == 1){
        //Encender radio
        radio.turnOn()
        println(radio)
    }
}
class Radio(
        private var vol: Int,
        private var est: Double,
        private var recep: String,
        var isTurnedOn: Boolean = false
){
    fun turnOn(){
        isTurnedOn = true
    }
    fun turnOff(){
        isTurnedOn = false
    }
    override fun toString(): String{
        return """Radio:
            Recpcion Actual: $recep Vol: $vol Estacion Actual: $est

            1. Cambiar (FM / AM)
            2. Subir Volumen
            3. Bajar Volumen
            4. Subir Estacion
            5. Bajar Estacion
            6. Apagar
            7. Salir
            Seleccion una opcion: """.trimIndent()
    }
}