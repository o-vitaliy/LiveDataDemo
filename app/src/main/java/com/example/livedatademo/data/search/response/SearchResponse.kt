package com.example.livedatademo.data.search.response

import com.google.gson.annotations.SerializedName

data class SearchResponse<T>(
        @SerializedName("total_count") val totalCount: Int,
        @SerializedName("items") val items: List<T>
)