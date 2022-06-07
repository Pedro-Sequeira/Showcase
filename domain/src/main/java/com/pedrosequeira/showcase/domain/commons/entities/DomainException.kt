package com.pedrosequeira.showcase.domain.commons.entities

class DomainException(
    val error: Error,
    cause: Throwable? = null
) : Exception(error.toString(), cause)
