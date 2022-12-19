package kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.repository

import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDetailDto
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}