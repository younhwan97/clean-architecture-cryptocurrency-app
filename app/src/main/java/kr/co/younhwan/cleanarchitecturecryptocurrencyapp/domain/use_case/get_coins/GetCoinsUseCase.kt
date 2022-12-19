package kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.common.Resource
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.remote.dto.toCoin
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.model.Coin
import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server."))
        }
    }
}