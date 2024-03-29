package com.example.themovieapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.themovieapp.data.vos.ProductionCompanyVO
import com.example.themovieapp.data.vos.ProductionCountryVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductionCountryTypeConverter {
    @TypeConverter
    fun toString(productionCountries: List<ProductionCountryVO>?):String {
        return Gson().toJson(productionCountries)
    }

    @TypeConverter
    fun toGenreIds(productionCountriesJSONString: String) : List<ProductionCountryVO>?{
        val productionCountriesListType = object : TypeToken<List<ProductionCountryVO>?>(){}.type
        return Gson().fromJson(productionCountriesJSONString, productionCountriesListType)
    }
}