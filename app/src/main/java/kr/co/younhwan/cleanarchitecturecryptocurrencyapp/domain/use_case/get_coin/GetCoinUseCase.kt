package kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.common.Resource
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDto
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.remote.dto.toCoin
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.remote.dto.toCoinDetail
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.model.Coin
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.model.CoinDetail
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server."))
        }
    }
}