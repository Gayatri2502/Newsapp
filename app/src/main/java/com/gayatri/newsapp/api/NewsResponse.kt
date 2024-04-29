package com.gayatri.newsapp.api
import com.google.gson.annotations.SerializedName
import java.util.ArrayList
import java.util.Date

data class NewsResponse(
    @SerializedName("status")
    val status : String,
    @SerializedName("articles")
    val articles : ArrayList<Article>
)


data class Article(
    @SerializedName("source")
    val source: Source,
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String?,
    @SerializedName("publishedAt")
    val publishedAt: String, // Assuming you're receiving date as string
    @SerializedName("content")
    val content: String?
)

data class Source(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String
)