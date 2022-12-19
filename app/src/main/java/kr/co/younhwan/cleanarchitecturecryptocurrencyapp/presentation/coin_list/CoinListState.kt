package kr.co.younhwan.cleanarchitecturecryptocurrencyapp.presentation.coin_list

import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)