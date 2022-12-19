package kr.co.younhwan.cleanarchitecturecryptocurrencyapp.domain.model

import kr.co.younhwan.cleanarchitecturecryptocurrencyapp.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
