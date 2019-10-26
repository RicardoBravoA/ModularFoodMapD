package com.rba.modular.mapd.data.datastore

import com.rba.modular.model.model.ErrorModel
import com.rba.modular.model.model.RestaurantModel
import com.rba.modular.util.domain.ResultType

interface RestaurantDataStore {

    suspend fun getRestaurantList(
        latitude: String,
        longitude: String
    ): ResultType<List<RestaurantModel>, ErrorModel>

}