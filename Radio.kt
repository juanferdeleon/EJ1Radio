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

        // Solicita una opcion del menu
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
                println("ERROR: $opSelec NO es una opcion valida, por favor ingrese un numero")
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

        var op2: Int = 0
        var opCor2: Boolean = false

        while (!opCor2) {
            //Imprimir el estado del radio y menu
            println(radio)

            //Solocita una opcion del menu
            val opSelec2: String? = readLine()

            if (opSelec2 != null) {
                try {
                    op2 = opSelec2.toInt()
                    if (op2 in 1..7){
                        opCor2 = false
                    }else {
                        println("ERROR: $op2 NO es una opcion valida")
                    }
                } catch (error: NumberFormatException) {
                    println("ERROR: $opSelec2 NO es una opcion valida, por favor ingrese un numero")
                }
            }

            //Primera opcion(Cambiar de FM a AM)
            if (op2 == 1){
                if (radio.recep == "F.M."){
                    radio.recep = "A.M."
                    radio.est = 560.0
                } else {
                    radio.recep = "F.M."
                    radio.est = 87.5
                }
            }

            //Subir volumen
            if (op2 == 2){
                if (radio.vol == 100){
                    println("El volumen esta al maximo")
                } else { radio.vol += 10 }
            }

            //Bajar volumen
            if (op2 == 3){
                if (radio.vol == 0){
                    println("El volumen esta al minimo")
                } else { radio.vol -= 10 }
            }

            //Subir estacion
            if (op2 == 4){

                var salto: Double = 0.0
                var opCor3: Boolean = false

                //Si Se encuentra en FM
                if (radio.recep == "F.M."){

                    //Solicitud de salto de estacion

                    do {
                        println("¿Cuanto sera su salto de estacion?: ")

                        // Solicita salto
                        val cantidadSalto: String? = readLine()

                        if (cantidadSalto != null) {
                            try {
                                salto = cantidadSalto.toDouble()
                                radio.est += salto
                                if (radio.est in 87.5..107.5){
                                    opCor3 = true
                                }else {
                                    println("ERROR: La estacion no existe")
                                    radio.est -= salto
                                }
                            } catch (error: NumberFormatException) {
                                println("ERROR: $cantidadSalto NO es una opcion valida, por favor ingrese un numero")
                                opCor3 = false
                            }
                        }

                    }while (!opCor3)
                }else {
                    //Si se encuentra en AM

                    //Solicitud de salto de estacion

                    do {
                        println("¿Cuanto sera su salto de estacion?: ")

                        // Solicita salto
                        val cantidadSalto: String? = readLine()

                        if (cantidadSalto != null) {
                            try {
                                salto = cantidadSalto.toDouble()
                                radio.est += salto
                                if (radio.est in 500..1600){
                                    opCor3 = true
                                }else {
                                    println("ERROR: La estacion no existe")
                                    radio.est -= salto
                                }
                            } catch (error: NumberFormatException) {
                                println("ERROR: $cantidadSalto NO es una opcion valida, por favor ingrese un numero")
                                opCor3 = false
                            }
                        }

                    }while (!opCor3)
                }
            }

            //Bajar estacion
            if (op2 == 5){

                var salto: Double = 0.0
                var opCor3: Boolean = false

                //Si Se encuentra en FM
                if (radio.recep == "F.M."){

                    //Solicitud de salto de estacion

                    do {
                        println("¿Cuanto sera su salto de estacion?: ")

                        // Solicita salto
                        val cantidadSalto: String? = readLine()

                        if (cantidadSalto != null) {
                            try {
                                salto = cantidadSalto.toDouble()
                                radio.est -= salto
                                if (radio.est in 87.5..107.5){
                                    opCor3 = true
                                }else {
                                    println("ERROR: La estacion no existe")
                                    radio.est += salto
                                }
                            } catch (error: NumberFormatException) {
                                println("ERROR: $cantidadSalto NO es una opcion valida, por favor ingrese un numero")
                                opCor3 = false
                            }
                        }

                    }while (!opCor3)
                }else {
                    //Si se encuentra en AM

                    //Solicitud de salto de estacion

                    do {
                        println("¿Cuanto sera su salto de estacion?: ")

                        // Solicita salto
                        val cantidadSalto: String? = readLine()

                        if (cantidadSalto != null) {
                            try {
                                salto = cantidadSalto.toDouble()
                                radio.est -= salto
                                if (radio.est in 500..1600){
                                    opCor3 = true
                                }else {
                                    println("ERROR: La estacion no existe")
                                    radio.est += salto
                                }
                            } catch (error: NumberFormatException) {
                                println("ERROR: $cantidadSalto NO es una opcion valida, por favor ingrese un numero")
                                opCor3 = false
                            }
                        }

                    }while (!opCor3)
                }
            }

            if (op2 == 6){
                radio.turnOff()
            }

            //Salir
            if (op2 == 7){
                opCor2 = true
            }
        }


    }
}


class Radio(
        var vol: Int,
        var est: Double,
        var recep: String,
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
            Seleccion una opcion:""".trimIndent()
    }
}
