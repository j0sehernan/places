package com.tyba.places.services

import com.tyba.places.constants.Actions
import com.tyba.places.constants.Routes
import com.tyba.places.entities.Transaction
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PlaceService(@Value("\${googleapis.api-key}")
                   private val googleapisApiKey: String,
                   private val transactionService: TransactionService
) {
    fun searchPlace(type: String, lat: Double, lng: Double, radius: Int): Any {
        transactionService.create(Transaction(action = Actions.SEARCH_PLACE))

        val client = OkHttpClient()
        val url = "${Routes.GOOGLEAPIS}/maps/api/place/nearbysearch/json?location=$lat,$lng&radius=$radius&type=$type&keyword=cruise&key=$googleapisApiKey"

        try {
            val request = Request.Builder().method(HttpMethod.GET.name, null).url(url).build()

            val response = client.newCall(request).execute()

            if (response.code() < HttpStatus.OK.value() || response.code() >= HttpStatus.MULTIPLE_CHOICES.value()) {
                throw ResponseStatusException(HttpStatus.valueOf(response.code()), response.body()!!.string())
            }

            return response.body().string()
        } catch (e: ResponseStatusException) {
            throw ResponseStatusException(HttpStatus.valueOf(e.status.value()), e.reason)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "$url, ${e.message}")
        }
    }
}