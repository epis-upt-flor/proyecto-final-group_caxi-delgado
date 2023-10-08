package com.xnical.combigo.presentation.screens.roles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.use_cases.auth.AuthUseCase
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description


@ExperimentalCoroutinesApi
class RolesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
    // Mock del AuthUseCase
    private val authUseCase = mockk<AuthUseCase>()
    // ViewModel para hacer las  pruebas
    private lateinit var rolesViewModel: RolesViewModel

    @Before
    fun setUp() {

        every { authUseCase.getSessionData() } returns flowOf(AuthResponse(token = "mocked_token"))

        rolesViewModel = RolesViewModel(authUseCase)
    }

    @After
    fun tearDown() {

        clearAllMocks()
    }

    @Test
    fun `getSessionData sets authResponse when token is not blank`() {

        rolesViewModel.getSessionData()


        assert(rolesViewModel.authResponse.token == "mocked_token")
    }

//    @Test
//    fun `getSessionData does not set authResponse when token is blank`() {
//
//        every { authUseCase.getSessionData() } returns flowOf(AuthResponse(token = ""))
//
//
//        rolesViewModel.getSessionData()
//
//
//        rolesViewModel.authResponse.token?.let { assert(it.isBlank()) }
//    }
}
class CoroutineTestRule(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : TestWatcher(), TestRule {

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }
    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}