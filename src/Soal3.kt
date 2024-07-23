import model.RevenueShare

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
    val hargaSebelumMarkup = 10000.0
    val markupPersen = 10.0
    val sharePersen = 20.0

    val hasil = hitungShareRevenue(hargaSebelumMarkup, markupPersen, sharePersen)

    println("Net untuk Resto: Rp ${String.format("%.2f", hasil.netUntukResto)}")
    println("Share untuk Ojol: Rp ${String.format("%.2f", hasil.shareUntukOjol)}")
}