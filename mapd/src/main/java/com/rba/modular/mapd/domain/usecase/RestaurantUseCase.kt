package com.rba.modular.mapd.domain.usecase

import com.rba.modular.mapd.domain.repository.RestaurantRepository
import com.rba.modular.model.model.ErrorModel
import com.rba.modular.model.model.RestaurantModel
import com.rba.modular.util.domain.ResultType

class RestaurantUseCase(private val restaurantRepository: RestaurantRepository) {

    suspend fun getRestaurantList(
        latitude: String,
        longitude: String
    ): ResultType<List<RestaurantModel>, ErrorModel> {
        return restaurantRepository.getRestaurantList(latitude, longitude)
    }

}