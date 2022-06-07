package com.pedrosequeira.showcase.domain.commons

import com.github.michaelbull.result.Result
import com.pedrosequeira.showcase.domain.commons.entities.Error

typealias DomainResult<T> = Result<T, Error>
