import model.FinanceIn
import model.FinanceOut
import model.FinanceStatement
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

fun buatLaporanMutasiKas(
    uangMasuk: List<FinanceIn>,
    uangKeluar: List<FinanceOut>,
    mulaiTanggal: String,
    sampaiTanggal: String
): List<FinanceStatement> {
    val formatTanggal = SimpleDateFormat("yyyy-MM-dd")
    val tanggalMulai = formatTanggal.parse(mulaiTanggal)
    val tanggalSelesai = formatTanggal.parse(sampaiTanggal)

    val kalender = Calendar.getInstance()
    kalender.time = tanggalMulai

    val laporan = ArrayList<FinanceStatement>()
    var saldo = 0

    while (!kalender.time.after(tanggalSelesai)) {
        val tanggal = formatTanggal.format(kalender.time)

        val amountIn = uangMasuk.filter { it.date == tanggal }.sumOf { it.amount }
        val amountOut = uangKeluar.filter { it.date == tanggal }.sumOf { it.amount }

        saldo += amountIn - amountOut

        laporan.add(FinanceStatement(tanggal, amountIn, amountOut, saldo))

        kalender.add(Calendar.DATE, 1)
    }

    return laporan
}

fun main() {

    val uangMasuk = arrayListOf(
        FinanceIn(1, "2021-09-29", 350000),
        FinanceIn(2, "2021-10-01", 200000),
        FinanceIn(3, "2021-10-03", 300000),
        FinanceIn(4, "2021-10-05", 150000),
    )

    val uangKeluar = arrayListOf(
        FinanceOut(1, "2021-09-30", 250000),
        FinanceOut(2, "2021-10-02", 100000),
        FinanceOut(3, "2021-10-04", 150000),
        FinanceOut(4, "2021-10-06", 50000),
    )

    val mulaiTanggal = "2021-10-01"
    val sampaiTanggal = "2021-10-06"

    val laporan = buatLaporanMutasiKas(uangMasuk, uangKeluar, mulaiTanggal, sampaiTanggal)

    println("Tanggal\t\tMasuk\tKeluar\tSaldo")
    for (data in laporan) {
        println("${data.date}\t${data.amountIn}\t\t${data.amountOut}\t${data.balance}")
    }
}