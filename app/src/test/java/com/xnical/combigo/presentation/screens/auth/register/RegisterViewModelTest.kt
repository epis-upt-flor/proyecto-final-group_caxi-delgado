package com.xnical.combigo.presentation.screens.auth.register

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.use_cases.auth.AuthUseCase
import com.xnical.combigo.domain.util.Resource
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class RegisterViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()
    private lateinit var viewModel: RegisterViewModel
    private val authUseCase: AuthUseCase = mockk()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = RegisterViewModel(authUseCase)
    }

    @Test
    fun `register sets registerResponse to Loading and then to Success when isValidForm is true`() = testDispatcher.runBlockingTest {

        viewModel.state = RegisterState(
            name = "John",
            lastname = "Doe",
            email = "test@example.com",
            phone = "1234567890",
            password = "password",
            confirmPassword = "password"
        )


        coEvery { authUseCase.register(any()) } returns Resource.Success(AuthResponse(token = "token"))

        // Llama a register en el ViewModel
        viewModel.register()


        assertEquals(Resource.Loading, viewModel.registerResponse)
        testDispatcher.scheduler.apply { advanceTimeBy(1000); runCurrent() }

        assertEquals(Resource.Success(AuthResponse(token = "token")), viewModel.registerResponse)

    }

//    @Test
//    fun `register sets registerResponse to Loading and then to Error when isValidForm is true and authUseCase returns Error`() = testDispatcher.runBlockingTest {
//        viewModel.state = RegisterState(
//            name = "John",
//            lastname = "Doe",
//            email = "test@example.com",
//            phone = "1234567890",
//            password = "password",
//            confirmPassword = "password"
//        )
//
//        // Configura el comportamiento de authUseCase.register() para esta prueba
//        coEvery { authUseCase.register(any()) } returns Resource.Failure("Registration failed")
//
//        val observer = mockk<Observer<Resource<AuthResponse>>>(relaxed = true)
//        viewModel.registerResponse.observeForever(observer)
//
//
//        viewModel.register()
//
//        verifyOrder {
//            observer.onChanged(Resource.Loading)
//            observer.onChanged(Resource.Failure("Registration failed"))
//        }
//    }

    @Test
    fun `isValidForm returns false and sets errorMessage for missing name`() {

        viewModel.state = RegisterState(
            lastname = "Doe",
            email = "test@example.com",
            phone = "1234567890",
            password = "password",
            confirmPassword = "password"
        )


        val result = viewModel.isValidForm()

        assertFalse(result)
        assertEquals("Ingresa el nombre", viewModel.errorMessage)
    }

    @Test
    fun `isValidForm returns false and sets errorMessage for missing lastname`() {

        viewModel.state = RegisterState(
            name = "John",
            email = "test@example.com",
            phone = "1234567890",
            password = "password",
            confirmPassword = "password"
        )


        val result = viewModel.isValidForm()

        assertFalse(result)
        assertEquals("Ingresa el apellido", viewModel.errorMessage)
    }

    @Test
    fun `isValidForm returns false and sets errorMessage for missing email`() {
        // Configura el estado del ViewModel para que falte el email
        viewModel.state = RegisterState(
            name = "John",
            lastname = "Doe",
            phone = "1234567890",
            password = "password",
            confirmPassword = "password"
        )


        val result = viewModel.isValidForm()

        assertFalse(result)
        assertEquals("Ingresa el email", viewModel.errorMessage)
    }

    @Test
    fun `isValidForm returns false and sets errorMessage for missing phone`() {

        viewModel.state = RegisterState(
            name = "John",
            lastname = "Doe",
            email = "test@example.com",
            password = "password",
            confirmPassword = "password"
        )


        val result = viewModel.isValidForm()

        assertFalse(result)
        assertEquals("Ingresa el telefono", viewModel.errorMessage)
    }

    @Test
    fun `isValidForm returns false and sets errorMessage for missing password`() {

        viewModel.state = RegisterState(
            name = "John",
            lastname = "Doe",
            email = "test@example.com",
            phone = "1234567890",
            confirmPassword = "password"
        )


        val result = viewModel.isValidForm()

        assertFalse(result)
        assertEquals("Ingresa el password", viewModel.errorMessage)
    }

    @Test
    fun `isValidForm returns false and sets errorMessage for missing confirmPassword`() {

        viewModel.state = RegisterState(
            name = "John",
            lastname = "Doe",
            email = "test@example.com",
            phone = "1234567890",
            password = "password"
        )


        val result = viewModel.isValidForm()

        assertFalse(result)
        assertEquals("Ingresa el password de confirmacion", viewModel.errorMessage)
    }

    @Test
    fun `isValidForm returns false and sets errorMessage for invalid email`() {
        // Configura el estado del ViewModel con un email no válido
        viewModel.state = RegisterState(
            name = "John",
            lastname = "Doe",
            email = "invalid_email",
            phone = "1234567890",
            password = "password",
            confirmPassword = "password"
        )


        val result = viewModel.isValidForm()

        assertFalse(result)
        assertEquals("El email no es valido", viewModel.errorMessage)
    }

    @Test
    fun `isValidForm returns false and sets errorMessage for short password`() {

        viewModel.state = RegisterState(
            name = "John",
            lastname = "Doe",
            email = "test@example.com",
            phone = "1234567890",
            password = "12345",
            confirmPassword = "12345"
        )


        val result = viewModel.isValidForm()

        assertFalse(result)
        assertEquals("La contraseña debe tener al menos 6 caracteres", viewModel.errorMessage)
    }

    @Test
    fun `isValidForm returns false and sets errorMessage when passwords do not match`() {

        viewModel.state = RegisterState(
            name = "John",
            lastname = "Doe",
            email = "test@example.com",
            phone = "1234567890",
            password = "password1",
            confirmPassword = "password2"
        )


        val result = viewModel.isValidForm()

        assertFalse(result)
        assertEquals("Las contraseñas no coinciden", viewModel.errorMessage)
    }

    @Test
    fun `isValidForm returns true for valid input`() {

        viewModel.state = RegisterState(
            name = "John",
            lastname = "Doe",
            email = "test@example.com",
            phone = "1234567890",
            password = "password",
            confirmPassword = "password"
        )


        val result = viewModel.isValidForm()

        assertTrue(result)
        assertEquals("", viewModel.errorMessage)
    }

}