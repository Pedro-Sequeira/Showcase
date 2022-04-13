package com.pedrosequeira.showcase.core.factories

private const val IMAGE_URL_TEMPLATE = "https://image.tmdb.org/t/p/%s%s"
private const val SIZE_DEFAULT = "w500"

fun createUrl(
    imageUrl: String,
    size: String = SIZE_DEFAULT
): String {
    return String.format(
        IMAGE_URL_TEMPLATE,
        size,
        imageUrl
    )
}
