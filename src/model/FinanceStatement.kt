package model

data class FinanceStatement(
    val date: String,
    val amountIn: Int,
    val amountOut: Int,
    val balance: Int
)