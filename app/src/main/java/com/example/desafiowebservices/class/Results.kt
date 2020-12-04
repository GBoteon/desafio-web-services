package com.example.desafiowebservices.`class`

import java.io.Serializable
import java.util.*

data class Results(val id: Int, var title: String, var issueNumber: Int, var thumbnail:Thumbnail, var description: String, var pageCount: Int, var prices: Array<ComicPrice>, var modified: Date, var dates: Array<DateHq>): Serializable
