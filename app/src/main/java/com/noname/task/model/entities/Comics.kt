package com.noname.task.model.entities

data class ComicsResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: ComicsData,
    val etag: String,
    val status: String
)

data class ComicsData(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ComicsResult>,
    val total: Int
)

data class ComicsResult(
    val characters: Characters,
    val collectedIssues: List<Any>,
    val collections: List<Any>,
    val creators: Creators,
    val dates: List<Date>,
    val description: String,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val events: Events,
    val format: String,
    val id: Int,
    val images: List<Any>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<Price>,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val textObjects: List<Any>,
    val thumbnail: ComicsThumbnail,
    val title: String,
    val upc: String,
    val urls: List<Url>,
    val variantDescription: String,
    val variants: List<Any>
)




data class ComicsThumbnail(
    val extension: String,
    val path: String
)

