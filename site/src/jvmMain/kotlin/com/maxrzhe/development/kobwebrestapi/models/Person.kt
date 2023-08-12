package com.maxrzhe.development.kobwebrestapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Person(
  val name: String,
  val age: Int
)