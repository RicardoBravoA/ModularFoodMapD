package com.rba.modular.mapd.domain.repository

import com.rba.modular.model.model.ErrorModel
import com.rba.modular.model.model.RestaurantModel
import com.rba.modular.util.domain.ResultType

interface RestaurantRepository {

    suspend fun getRestaurantList(
        latitude: String,
        longitude: String
    ): ResultType<List<RestaurantModel>, ErrorModel>

}