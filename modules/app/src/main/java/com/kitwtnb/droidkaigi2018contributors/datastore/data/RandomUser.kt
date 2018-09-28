package com.kitwtnb.droidkaigi2018contributors.datastore.data

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class RandomUser(var info: Info,
                      var results: List<Result>)

data class Info(var seed: String,
                var results: Int,
                var page: Int,
                var version: String)

data class Result(var gender: String,
                  var name: Name,
                  var email: String,
                  var registered: Registered,
                  var dob: Dob,
                  var phone: String,
                  var cell: String)

data class Name(val title: String,
                val first: String,
                val last: String)

data class Registered(val date: String,
                      val age: Int)

data class Dob(val date: String,
               val age: Int)
