package kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.repository

import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.remote.CoinPaprikaApi
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDetailDto
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDto
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}