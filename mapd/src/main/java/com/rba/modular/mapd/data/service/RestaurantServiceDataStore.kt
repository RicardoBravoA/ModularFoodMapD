package com.rba.modular.mapd.data.service

import com.rba.modular.mapd.data.api.ApiManager
import com.rba.modular.mapd.data.datastore.RestaurantDataStore
import com.rba.modular.mapd.data.util.RetrofitErrorUtil
import com.rba.modular.model.mapper.ErrorMapper
import com.rba.modular.model.mapper.RestaurantMapper
import com.rba.modular.model.model.ErrorModel
import com.rba.modular.model.model.RestaurantModel
import com.rba.modular.util.data.ErrorUtil
import com.rba.modular.util.domain.ResultType

class RestaurantServiceDataStore : RestaurantDataStore {

    override suspend fun getRestaurantList(
        latitude: String,
        longitude: String
    ): ResultType<List<RestaurantModel>, ErrorModel> {

        return try {
            val response = ApiManager.apiManager().restaurantList(latitude, longitude).await()
            if (response.isSuccessful) {
                val movieResponse = response.body()
                ResultType.Success(RestaurantMapper.transform(movieResponse!!))
            } else {
                val error = RetrofitErrorUtil.parseError(response)!!
                ResultType.Error(ErrorMapper.transform(error))
            }
        } catch (t: Throwable) {
                ResultType.Error(ErrorUtil.errorHandler(t))
        }

    }
}