import model.Barang
import model.Harga
import java.util.*

fun hitungHarga(totalHarga: Double, persenPajak: Double): Harga {
    val pajakRp = totalHarga * (persenPajak / 100)
    val netSales = totalHarga - pajakRp
    return Harga(netSales, pajakRp)
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

                val persenPajak = 10.0
                val harga = hitungHarga(totalHarga, persenPajak)

                println("\nNet Sales: Rp ${String.format("%.0f", harga.netSales)}")
                println("Pajak yang berlaku ${String.format("%.0f", persenPajak)}%: Rp ${String.format("%.0f", harga.pajakRp)}\n")
            }
            2 -> {
                println("Keluar dari aplikasi.")
                return
            }
            else -> println("Pilihan tidak valid")
        }
    }
}
