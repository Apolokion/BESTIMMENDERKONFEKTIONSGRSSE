package com.example.bestimmenderkonfektionsgrsse

fun bestimmKonfektionsgroesse(brustumfang: Int, koerpergroesse: Int, geschlecht: Int): String {
    val grundGroesse = brustumfang / 2

    return when {
        geschlecht == 0 -> grundGroesse.toString()  // Konfektionsgröße für Männer
        geschlecht == 1 -> {
            when {
                koerpergroesse in 164..170 -> (grundGroesse - 6).toString()  // Normalgröße
                koerpergroesse > 170 -> (grundGroesse * 2 - 6).toString()  // Langgröße
                koerpergroesse < 164 -> (grundGroesse / 2 - 6).toString()  // Kurzgröße
                else -> grundGroesse.toString()
            }
        }
        else -> "Ungültiges Geschlecht"
    }
}

fun main() {
    val input1 = "90 185 0"
    val input2 = "92 166 1"

    val (brustumfang1, koerpergroesse1, geschlecht1) = input1.split(" ").map { it.toInt() }
    val (brustumfang2, koerpergroesse2, geschlecht2) = input2.split(" ").map { it.toInt() }

    val output1 = bestimmKonfektionsgroesse(brustumfang1, koerpergroesse1, geschlecht1)
    val output2 = bestimmKonfektionsgroesse(brustumfang2, koerpergroesse2, geschlecht2)

    println("Input: '$input1' - Output: '$output1'")
    println("Input: '$input2' - Output: '$output2'")
}
