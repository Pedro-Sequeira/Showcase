package com.pedrosequeira.showcase.moviedetails

import com.pedrosequeira.showcase.core.ErrorMapper
import com.pedrosequeira.showcase.domain.tests.EMPTY
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test
import com.pedrosequeira.showcase.domain.movies.MovieDetails as Details

internal class MovieDetailsReducerTest {

    private val errorMapper: ErrorMapper = mockk()

    private val sut = MovieDetailsReducer(errorMapper)

    @Test
    fun `map to success`() {
        val state = MovieDetailsState()
        val details = Details.EMPTY
        assertEquals(
            MovieDetailsState(details),
            sut.mapToSuccessState(state, details)
        )
    }

    @Test
    fun `change loading state`() {
        val state = MovieDetailsState()

        assertEquals(
            MovieDetailsState(isLoading = true),
            sut.changeLoadingStateTo(state, true)
        )
        assertEquals(
            MovieDetailsState(isLoading = false),
            sut.changeLoadingStateTo(state, false)
        )
    }

    @Test
    fun `map to error state`() {
        val state = MovieDetailsState()

        every {
            errorMapper.mapToMessage(any())
        } returns "Oops! Something went wrong."

        assertEquals(
            MovieDetailsState(errorMessage = "Oops! Something went wrong."),
            sut.mapToErrorState(state, Throwable())
        )
    }
}
