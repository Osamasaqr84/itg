package com.noname.task.datalayer.repositries

import com.noname.task.datalayer.apidata.ServerGateway
import com.noname.task.model.entities.*
import com.noname.task.model.usecases.Constant.Companion.ApiKey
import com.noname.task.model.usecases.Constant.Companion.Hash
import com.noname.task.model.usecases.Constant.Companion.ts
import io.reactivex.Observable


fun retrieveCharcts(server: ServerGateway, page: Int): Observable<Charachts> {
    return server.retrieveCharcts(page*10,Hash,ApiKey,ts)
}

fun retrieveSearchCharcts(server: ServerGateway, name: String): Observable<Charachts> {
    return server.retrieveSearchCharcts(name,Hash,ApiKey,ts)
}

fun retrieveCharchtDetail(server: ServerGateway,charchId: Int): Observable<CharchtDetails> {
    return server.retrieveCharchtDetails(charchId,Hash,ApiKey,ts)
}

fun retrieveComics(server: ServerGateway,charchId: Int): Observable<ComicsResponse> {
    return server.retrieveComicsResponse(charchId,Hash,ApiKey,ts)
}

fun retrieveSeries(server: ServerGateway,charchId: Int): Observable<ComicsResponse> {
    return server.retrieveSeriesResponse(charchId,Hash,ApiKey,ts)
}
fun retrieveStories(server: ServerGateway,charchId: Int): Observable<ComicsResponse> {
    return server.retrieveStoriesResponse(charchId,Hash,ApiKey,ts)
}
fun retrieveEvents(server: ServerGateway,charchId: Int): Observable<ComicsResponse> {
    return server.retrieveEventsResponse(charchId,Hash,ApiKey,ts)
}