package study.nobreak.personalposts.so.web.response

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import study.nobreak.personalposts.so.mock.mockSoPost

internal class SoPostResponseItemTest {
    @Test
    fun `fromSoPost`() {
        val result1 = SoPostResponseItem.fromSoPost(
            mockSoPost(
                id = 1L,
                title = "title-1",
                content = "content-1"
            )
        )
        val result2 = SoPostResponseItem.fromSoPost(
            mockSoPost(
                id = 2L,
                title = "title-2",
                content = "content-2",
                question = "question-2"
            )
        )
        
        assertEquals(1L, result1.id)
        assertEquals("title-1", result1.title)
        assertEquals("content-1", result1.content)
        assertEquals("", result1.hiddenContentQuestion)
        
        assertEquals(2L, result2.id)
        assertEquals("title-2", result2.title)
        assertEquals("content-2", result2.content)
        assertEquals("question-2", result2.hiddenContentQuestion)
    }
}
