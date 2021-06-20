package study.nobreak.personalposts.so.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import study.nobreak.personalposts.so.exception.DataConflictException
import study.nobreak.personalposts.so.mock.mockSoPost

internal class SoPostTest {
    @Test
    fun `SoPost class`() {
        val post =  mockSoPost(1L, "title-1", "content-1")
        
        assertEquals(1L, post.id)
        assertEquals("title-1", post.title)
        assertEquals("content-1", post.content)
    }
    
    @Test
    fun `addHiddenContent success`() {
        val post = mockSoPost(1)
        val hiddenContent = post.addHiddenContent(
            question = "question-1",
            answer = "answer-1",
            hiddenContent = "content-1"
        )
        
        assertEquals("question-1", hiddenContent.question)
        assertEquals("answer-1", hiddenContent.answer)
        assertEquals("content-1", hiddenContent.content)
        assertEquals(hiddenContent, post.hiddenContent)
        assertEquals(post, hiddenContent.post)
    }
    
    @Test
    fun `addHiddenContent throw DataConflictException when data already exists`() {
        val post = mockSoPost(1)
        post.addHiddenContent(
            question = "question-1",
            answer = "answer-1",
            hiddenContent = "content-1"
        )
        
        assertThrows<DataConflictException> {
            post.addHiddenContent(
                question = "question-1",
                answer = "answer-1",
                hiddenContent = "content-1"
            )
        }
    }
}
