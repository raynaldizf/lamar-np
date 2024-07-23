import model.RevenueShare
import java.util.Scanner

fun hitungShareRevenue(
    hargaSebelumMarkup: Double,
    markupPersen: Double,
    sharePersen: Double
): RevenueShare {
    val hargaSetelahMarkup = hargaSebelumMarkup * (1 + markupPersen / 100)
    val shareUntukOjol = hargaSetelahMarkup * (sharePersen / 100)
    val netUntukResto = hargaSetelahMarkup - shareUntukOjol

    return RevenueShare(netUntukResto, shareUntukOjol)
}

fun main() {
    val input = Scanner(System.`in`)

    print("Masukkan nama barang: ")
    val namaBarang = input.nextLine()

    print("Masukkan harga barang sebelum markup: ")
    val hargaSebelumMarkup = input.nextDouble()

    print("Masukkan persentase markup: ")
    val markupPersen = input.nextDouble()

    print("Masukkan persentase share: ")
    val sharePersen = input.nextDouble()

    val hasil = hitungShareRevenue(hargaSebelumMarkup, markupPersen, sharePersen)

    println("\nNama Barang: $namaBarang")
    println("Net untuk Resto: Rp ${String.format("%.2f", hasil.netUntukResto)}")
    println("Share untuk Ojol: Rp ${String.format("%.2f", hasil.shareUntukOjol)}")
}
