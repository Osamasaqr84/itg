package com.noname.task.datalayer.apidata

import com.noname.task.model.entities.Charachts
import com.noname.task.model.entities.CharchtDetails
import com.noname.task.model.entities.ComicsResponse
import com.noname.task.model.usecases.Constant

import io.reactivex.Observable
import retrofit2.http.*

interface ServerGateway {

    @GET(Constant.BASE_CHARACTERS_URL)
    fun retrieveCharcts(
        @Query("limit") page: Int,
        @Query("hash") Hash: String,
        @Query("apikey") Apikey: String,
        @Query("ts") ts: String
    ): Observable<Charachts>


    @GET(Constant.BASE_CHARACTERS_URL)
    fun retrieveSearchCharcts(
        @Query("nameStartsWith") name: String,
        @Query("hash") Hash: String,
        @Query("apikey") Apikey: String,
        @Query("ts") ts: String
    ): Observable<Charachts>

    @GET(Constant.BASE_CHARACTERS_URL + "/{charchId}")
    fun retrieveCharchtDetails(
        @Path("charchId") charchId: Int,
        @Query("hash") Hash: String,
        @Query("apikey") Apikey: String,
        @Query("ts") ts: String
    ): Observable<CharchtDetails>

    @GET(Constant.BASE_CHARACTERS_URL + "/{charchId}/comics")
    fun retrieveComicsResponse(
        @Path("charchId") charchId: Int,
        @Query("hash") Hash: String,
        @Query("apikey") Apikey: String,
        @Query("ts") ts: String
    ): Observable<ComicsResponse>


    @GET(Constant.BASE_CHARACTERS_URL + "/{charchId}/series")
    fun retrieveSeriesResponse(
        @Path("charchId") charchId: Int,
        @Query("hash") Hash: String,
        @Query("apikey") Apikey: String,
        @Query("ts") ts: String
    ): Observable<ComicsResponse>

    @GET(Constant.BASE_CHARACTERS_URL + "/{charchId}/srories")
    fun retrieveStoriesResponse(
        @Path("charchId") charchId: Int,
        @Query("hash") Hash: String,
        @Query("apikey") Apikey: String,
        @Query("ts") ts: String
    ): Observable<ComicsResponse>

    @GET(Constant.BASE_CHARACTERS_URL + "/{charchId}/events")
    fun retrieveEventsResponse(
        @Path("charchId") charchId: Int,
        @Query("hash") Hash: String,
        @Query("apikey") Apikey: String,
        @Query("ts") ts: String
    ): Observable<ComicsResponse>


}
