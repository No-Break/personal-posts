package study.nobreak.personalposts.so.service

import io.mockk.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import study.nobreak.personalposts.so.domain.SoPost
import study.nobreak.personalposts.so.exception.DataConflictException
import study.nobreak.personalposts.so.exception.NoDataFoundException
import study.nobreak.personalposts.so.mock.mockSoPost
import study.nobreak.personalposts.so.repository.SoPostRepository
import java.util.*

internal class SoPostServiceImplTest {
    private val soPostRepository: SoPostRepository = mockk()
    private val soPostService: SoPostService = SoPostServiceImpl(soPostRepository)
    
    @AfterEach
    fun afterTests() {
        unmockkAll()
    }
    
    @Test
    fun `addPost success`() {
        every {
            soPostRepository.save(any())
        } returns mockSoPost(
            id = 1,
            title = "title",
            content = "content"
        )
        
        soPostService.addPost(authorId = 1L, title = "title", content = "content")
        
        verify { soPostRepository.save(SoPost(authorId = 1L, title = "title", content = "content")) }
    }
    
    @Test
    fun `getAll success`() {
        every {
            soPostRepository.findAllByFetchJoinCondition(true, any())
        } returns PageImpl(
            listOf(
                mockSoPost(id = 1, title = "title-1"),
                mockSoPost(id = 2),
                mockSoPost(id = 3),
                mockSoPost(id = 4)
            )
        )
        val result = soPostService.getAll(true, PageRequest.of(1, 10))
        
        assertEquals(4, result.size)
        assertEquals("title-1", result.content[0].title)
    }
    
    @Test
    fun `deletePost success`() {
        every {
            soPostRepository.deleteById(any())
        } returns Unit
        
        soPostService.deletePost(1)
        
        verify { soPostRepository.deleteById(1) }
    }
    
    @Test
    fun `deletePost throw NoDataFoundException when catch EmptyResultDataAccessException`() {
        every {
            soPostRepository.deleteById(1)
        } throws EmptyResultDataAccessException(1)
        
        assertThrows<NoDataFoundException> {
            soPostService.deletePost(1)
        }
    }
    
    @Test
    fun `addHiddenContent success`() {
        val mockPost = spyk(mockSoPost(1, "title", "content"))
        every {
            soPostRepository.findById(any())
        } returns Optional.of(mockPost)
        
        soPostService.addHiddenContent(1, "question-1", "answer-1", "content-1")
        
        verify { mockPost.addHiddenContent("question-1", "answer-1", "content-1") }
    }
    
    @Test
    fun `addHiddenContent throw NoDataFoundException when find result is null`() {
        every {
            soPostRepository.findById(any())
        } returns Optional.empty()
        
        assertThrows<NoDataFoundException> {
            soPostService.addHiddenContent(1, "question-1", "answer-1", "content-1")
        }
    }
    
    @Test
    fun `addHiddenContent throw DataConflictException when data already exists`() {
        every {
            soPostRepository.findById(any())
        } returns Optional.of(
            mockSoPost(1, "title", "content", 1L, "question", "answer", "content")
        )
        
        assertThrows<DataConflictException> {
            soPostService.addHiddenContent(1, "question-1", "answer-1", "content-1")
        }
    }
}
