package com.tyba.places.controllers

import com.tyba.places.constants.Routes
import com.tyba.places.services.PlaceService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [Routes.PLACES], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
class PlaceController(private val placeService: PlaceService) {
    /**
     * SearchPlaces from GooglePlaces Api
     *
     * @param type of a Place
     * @param lat of a Place location
     * @param lng of a Place location
     * @param radius of a Place location
     * @return Any with all attributes of a GooglePlaces Api
     */
    @GetMapping
    fun searchPlace(
        @RequestParam type: String,
        @RequestParam lat: Double,
        @RequestParam lng: Double,
        @RequestParam radius: Int
    ): Any {
        return placeService.searchPlace(type, lat, lng, radius)
    }
}