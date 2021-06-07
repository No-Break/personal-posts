package study.nobreak.personalposts

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.boot.ApplicationContextFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType

internal class PersonalPostsApplicationTests {
    @Test
    fun mainShouldStartMyApplication() {
        mockkStatic(SpringApplication::class)
        
        every {
            SpringApplication.run(any())
        } returns ApplicationContextFactory.DEFAULT.create(WebApplicationType.NONE)
        
        main(arrayOf())
        
        verify {
            SpringApplication.run(PersonalPostsApplication::class.java)
        }
        unmockkStatic(SpringApplication::class)
    }
}
