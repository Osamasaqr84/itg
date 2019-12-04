package com.noname.task.model.entities

data class CharchtDetails(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: CharchtData,
    val etag: String,
    val status: String
)

data class CharchtData(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)

data class Result(
    val comics: CharchtComics,
    val description: String,
    val events: CharchtEvents,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: CharchtSeries,
    val stories: CharchtStories,
    val thumbnail: CharchtThumbnail,
    val urls: List<CharchtUrl>
)

data class CharchtComics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class Item(
    val name: String,
    val resourceURI: String,
    val imageURI: String
)

data class CharchtEvents(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class ItemX(
    val name: String,
    val resourceURI: String
)

data class CharchtSeries(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class ItemXX(
    val name: String,
    val resourceURI: String
)

data class CharchtStories(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)

data class ItemXXX(
    val name: String,
    val resourceURI: String,
    val type: String
)

data class CharchtThumbnail(
    val extension: String,
    val path: String
)

data class  CharchtUrl(
    val type: String,
    val url: String
)