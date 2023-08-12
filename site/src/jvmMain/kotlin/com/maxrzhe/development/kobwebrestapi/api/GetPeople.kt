package com.maxrzhe.development.kobwebrestapi.api

import com.maxrzhe.development.kobwebrestapi.models.ApiResponse
import com.maxrzhe.development.kobwebrestapi.models.Person
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val people = listOf(
  Person(name = "Max", age = 38),
  Person(name = "Mike", age = 19),
  Person(name = "Poul", age = 36),
  Person(name = "John", age = 15),
  Person(name = "Sam", age = 29),
  Person(name = "Bob", age = 41),
  Person(name = "Ron", age = 45),
  Person(name = "Kal", age = 21),
)

@Api
suspend fun getPeople(context: ApiContext) {
  try {
    val number = context.req.params.getValue("count").toInt()
    context.res.setBodyText(
      Json.encodeToString<ApiResponse>(
        ApiResponse.Success(data = people.take(number))
      )
    )
  } catch (e: Exception) {
    context.res.setBodyText(
      Json.encodeToString<ApiResponse>(
        ApiResponse.Error(errorMessage = e.message.toString())
      )
    )
  }
}