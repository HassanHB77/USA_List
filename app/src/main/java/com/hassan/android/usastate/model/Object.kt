package com.hassan.android.usastate.model

data class Object(
    val caucus: Any,
    val congress_numbers: List<Int>,
    val current: Boolean,
    val description: String,
    val district: Any,
    val enddate: String,
    val extra: Extra,
    val leadership_title: Any,
    val party: String,
    val person: Person,
    val phone: String,
    val role_type: String,
    val role_type_label: String,
    val senator_class: String,
    val senator_class_label: String,
    val senator_rank: String,
    val senator_rank_label: String,
    val startdate: String,
    val state: String,
    val title: String,
    val title_long: String,
    val website: String
)