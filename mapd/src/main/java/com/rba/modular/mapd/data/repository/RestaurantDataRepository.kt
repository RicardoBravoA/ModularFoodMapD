package com.rba.modular.mapd.data.repository

import com.rba.modular.mapd.data.service.RestaurantServiceDataStore
import com.rba.modular.mapd.domain.repository.RestaurantRepository
import com.rba.modular.model.model.ErrorModel
import com.rba.modular.model.model.RestaurantModel
import com.rba.modular.util.domain.ResultType

class RestaurantDataRepository : RestaurantRepository {
    override suspend fun getRestaurantList(
        latitude: String,
        longitude: String
    ): ResultType<List<RestaurantModel>, ErrorModel> {
        val restaurantServiceDataStore = RestaurantServiceDataStore()
        return restaurantServiceDataStore.getRestaurantList(latitude, longitude)
    }

}