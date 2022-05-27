package com.pedrosequeira.showcase.mdb.api

import com.github.michaelbull.result.Result
import com.pedrosequeira.showcase.mdb.api.entities.Error

typealias ApiResult<T> = Result<T, Error>
