/*Radio Ejercicio 1
10/07/2018
Juan Fernando De Leon Quzada
Carne 17822
POO
 */

package main

fun main(args: Array<String>) {
        var op: Int
        var opCor: Boolean = false
        do {
                print("""Radio:
                    1. Encender
                    2. Salir
                    """)
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
}