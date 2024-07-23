import model.Barang
import model.DiskonResult
import java.util.*

fun hitungDiskonBertingkat(discounts: IntArray, totalSebelumDiskon: Double): DiskonResult {
    var totalHarga = totalSebelumDiskon
    var totalDiskon = 0.0

    for (diskon in discounts) {
        val jumlahDiskon = totalHarga * (diskon / 100.0)
        totalDiskon += jumlahDiskon
        totalHarga -= jumlahDiskon
    }

    return DiskonResult(totalDiskon, totalHarga)
}

fun main() {
    val listBarang = mutableListOf<Barang>()
    val input = Scanner(System.`in`)
    var totalHarga = 0.0

    while (true) {
        println("1. Input Barang")
        println("2. Keluar Aplikasi")
        print("Pilihan Anda: ")
        val pilihan = input.nextInt()

        when (pilihan) {
            1 -> {
                while (true) {
                    input.nextLine()
                    print("Masukkan nama barang: ")
                    val namaBarang = input.nextLine()
                    print("Masukkan harga barang: ")
                    val hargaBarang = input.nextDouble()

                    listBarang.add(Barang(namaBarang, hargaBarang))
                    totalHarga += hargaBarang

                    print("Input barang lagi? (y/n): ")
                    val lanjut = input.next().lowercase()

                    if (lanjut == "y") {
                        continue
                    } else if (lanjut == "n") {
                        break
                    } else {
                        println("Pilihan tidak valid")
                    }
                }

                println("\nDaftar Barang:")
                for (barang in listBarang) {
                    println("- ${barang.namaBarang} (Rp ${String.format("%.0f", barang.hargaBarang)})")
                }

                val discounts = intArrayOf(20, 10)
                val diskonResult = hitungDiskonBertingkat(discounts, totalHarga)

                println("\nTotal Sebelum Diskon: Rp ${String.format("%.0f", totalHarga)}")
                println("Total Diskon: Rp ${String.format("%.0f", diskonResult.totalDiskon)}")
                println("Total Harga Setelah Diskon: Rp ${String.format("%.0f", diskonResult.totalHargaSetelahDiskon)}\n")
            }
            2 -> {
                println("Keluar dari aplikasi.")
                return
            }
            else -> println("Pilihan tidak valid")
        }
    }
}
