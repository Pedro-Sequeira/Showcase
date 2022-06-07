package com.pedrosequeira.showcase.data.commons

import com.github.michaelbull.result.Result
import com.pedrosequeira.showcase.data.commons.entities.Error

typealias DataResult<T> = Result<T,Error>
