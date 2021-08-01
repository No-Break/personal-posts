package study.nobreak.personalposts.so.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.ActiveProfiles
import study.nobreak.personalposts.so.domain.SoPost
import study.nobreak.personalposts.so.domain.SoUser

@DataJpaTest
@ActiveProfiles("test")
internal class SoPostDslRepositoryImplTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val soPostRepository: SoPostRepository,
) {
    @Test
    fun `findAllByFetchJoinCondition isHiddenContentIncluded true success`() {
        entityManager.apply {
            persist(SoUser(id = 1L, name = "홍길동"))
            persist(SoPost(authorId = 1L, title = "title-0", content = "content-0"))
            persist(SoPost(authorId = 1L, title = "title-1", content = "content-1").apply {
                addHiddenContent("question-1", "answer-1", "hidden-content-1")
            })
            flush()
            clear()
        }
        val result = soPostRepository.findAllByFetchJoinCondition(true, PageRequest.of(0, 10))
        
        assertEquals(10, result.size)
        assertEquals(1, result.totalPages)
        assertEquals(2, result.totalElements)
        assertEquals("title-0", result.content[0].title)
        assertEquals("content-0", result.content[0].content)
        assertEquals(null, result.content[0].hiddenContent)
        assertEquals("title-1", result.content[1].title)
        assertEquals("content-1", result.content[1].content)
        assertEquals("question-1", result.content[1].hiddenContent!!.question)
        assertEquals("answer-1", result.content[1].hiddenContent!!.answer)
        assertEquals("hidden-content-1", result.content[1].hiddenContent!!.content)
    }
    
    @Test
    fun `findAllByFetchJoinCondition isHiddenContentIncluded false success`() {
        entityManager.apply {
            persist(SoUser(id = 1L, name = "홍길동"))
            persist(SoPost(authorId = 1L, title = "title-0", content = "content-0"))
            persist(SoPost(authorId = 1L, title = "title-1", content = "content-1").apply {
                addHiddenContent("question-1", "answer-1", "hidden-content-1")
            })
            flush()
            clear()
        }
        val result = soPostRepository.findAllByFetchJoinCondition(false, PageRequest.of(0, 10))
        
        assertEquals(10, result.size)
        assertEquals(1, result.totalPages)
        assertEquals(2, result.totalElements)
        assertEquals("title-0", result.content[0].title)
        assertEquals("content-0", result.content[0].content)
        assertEquals(null, result.content[0].hiddenContent)
        assertEquals("title-1", result.content[1].title)
        assertEquals("content-1", result.content[1].content)
        assertEquals("question-1", result.content[1].hiddenContent!!.question)
        assertEquals("answer-1", result.content[1].hiddenContent!!.answer)
        assertEquals("hidden-content-1", result.content[1].hiddenContent!!.content)
    }
}
