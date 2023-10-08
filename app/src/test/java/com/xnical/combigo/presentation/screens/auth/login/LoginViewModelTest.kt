package com.xnical.combigo.presentation.screens.auth.login



import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.model.Rol
import com.xnical.combigo.domain.model.User
import com.xnical.combigo.domain.use_cases.auth.AuthUseCase
import com.xnical.combigo.presentation.screens.roles.CoroutineTestRule
import com.xnical.combigo.domain.util.Resource
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4



@RunWith(JUnit4::class)
class LoginViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    // Crea un objeto simulado de tu caso de uso
    private val authUseCase = mockk<AuthUseCase>()

    // Inicializa tu ViewModel con el objeto simulado
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        // Inicializa tu ViewModel en el método setup
        viewModel = LoginViewModel(authUseCase)



    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test login success`() = coroutineTestRule.testDispatcher.runBlockingTest {



    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test save session`() = coroutineTestRule.testDispatcher.runBlockingTest {

    }

    @Test
    fun `test on email input`() {
        // Prepara los datos que pasarás a tu método
        val email = "test@example.com"

        // Llama al método que quieres probar
        viewModel.onEmailInput(email)

        // Verifica que el estado del ViewModel se actualizó correctamente
        assertEquals(email, viewModel.state.email)
    }

    @Test
    fun `test on password input`() {
        // Prepara los datos que pasarás a tu método
        val password = "password"

        // Llama al método que quieres probar
        viewModel.onPasswordInput(password)

        // Verifica que el estado del ViewModel se actualizó correctamente
        assertEquals(password, viewModel.state.password)
    }

    @Test
    fun testValidEmailAndPassword() {
        // Simula un estado (state) válido
        viewModel.state.email = "usuario@example.com"
        viewModel.state.password = "123456"

        // Llama a la función isValidForm() y verifica que devuelva true
        assertTrue(viewModel.isValidForm())
    }

    @Test
    fun testInvalidEmail() {
        // Simula un estado (state) con un email no válido
        viewModel.state.email = "correo_invalido"
        viewModel.state.password = "123456"

        // Llama a la función isValidForm() y verifica que devuelva false
        assertFalse(viewModel.isValidForm())

        // Verifica que el mensaje de error sea el esperado
        assertEquals("El email no es valido", viewModel.errorMessage)
    }

    @Test
    fun testShortPassword() {
        // Simula un estado (state) con una contraseña demasiado corta
        viewModel.state.email = "usuario@example.com"
        viewModel.state.password = "123"

        // Llama a la función isValidForm() y verifica que devuelva false
        assertFalse(viewModel.isValidForm())

        // Verifica que el mensaje de error sea el esperado
        assertEquals("La contraseña debe tener al menos 6 caracteres", viewModel.errorMessage)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test getSessionData with valid session data`() = coroutineTestRule.testDispatcher.runBlockingTest {
        // Prepara los datos que retornará tu caso de uso simulado

        val rol = Rol("CLIENT","Cliente","https://firebasestorage.googleapis.com/v0/b/api-users-7d02b.appspot.com/o/client.png?alt=media&token=207ef81c-fe4a-4528-9f71-cf80396db016","client/home")
        val roles = arrayListOf(rol)
        val user = User("10","hola","hola","hola@gmail.com","123452345","","","",roles)

        val authResponse = AuthResponse(user,"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTAsIm5hbWUiOiJob2xhIiwicm9sZXMiOlsiQ0xJRU5UIl0sImlhdCI6MTY5NjYzMzcwNywiZXhwIjoxNjk2Njc2OTA3fQ.BrkANlikkxQMDfVnrSXC1Sds-kn9hkE5UNET9hxOOzE")


        // Indica qué debe retornar tu caso de uso cuando se llame al método getSessionData
        coEvery { authUseCase.getSessionData() } returns flowOf(authResponse)

        // Llama al método que quieres probar
        viewModel.getSessionData()

        // Verifica que el resultado es el esperado
        assertEquals(Resource.Success(authResponse), viewModel.loginResponse)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test getSessionData with no session data`() = coroutineTestRule.testDispatcher.runBlockingTest {

        val rol = Rol("b","dgbdb","dbdb","dbdb")
        val roles = arrayListOf(rol)
        val user = User("dbdb","dbdb","db","db","db","db","db","db",roles)

        val authResponse = AuthResponse(user,"dbbd")


        // Indica qué debe retornar tu caso de uso cuando se llame al método getSessionData
        coEvery { authUseCase.getSessionData() } returns flowOf(authResponse)

        // Llama al método que quieres probar
        viewModel.getSessionData()

        // Verifica que el resultado es el esperado
        assertEquals(Resource.Success(authResponse), viewModel.loginResponse)
    }
}
