package study.nobreak.personalposts.so.web

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import study.nobreak.personalposts.so.exception.DataConflictException
import study.nobreak.personalposts.so.exception.NoDataFoundException
import study.nobreak.personalposts.so.mock.mockSoPost
import study.nobreak.personalposts.so.service.SoPostService

@WebMvcTest(SoPostController::class)
internal class SoPostControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc
    
    @MockkBean
    lateinit var soPostService: SoPostService
    
    @Test
    fun `getPosts success`() {
        every { soPostService.getAllPosts() } returns listOf(
            mockSoPost(id = 1, title = "title-1", content = "content-1", question = "hiddenContentQuestion-1"),
            mockSoPost(id = 2, title = "title-2", content = "content-2", question = "hiddenContentQuestion-2")
        )
        
        mockMvc.perform(get("/so/posts"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.list[0].id").value("1"))
            .andExpect(jsonPath("$.list[0].title").value("title-1"))
            .andExpect(jsonPath("$.list[0].content").value("content-1"))
            .andExpect(jsonPath("$.list[0].hiddenContentQuestion").value("hiddenContentQuestion-1"))
            .andExpect(jsonPath("$.list[1].id").value("2"))
            .andExpect(jsonPath("$.list[1].title").value("title-2"))
            .andExpect(jsonPath("$.list[1].content").value("content-2"))
            .andExpect(jsonPath("$.list[1].hiddenContentQuestion").value("hiddenContentQuestion-2"))
    }
    
    @Test
    fun `addPost success`() {
        every { soPostService.addPost(any(), any()) } returns Unit
        
        mockMvc.perform(
            post("/so/posts")
                .contentType(MediaType.APPLICATION_JSON)
                //language=json
                .content("{\n  \"title\": \"title-1\",\n  \"content\": \"content-1\"\n}")
        ).andExpect(status().isCreated)
        
        verify { soPostService.addPost("title-1", "content-1") }
    }
    
    @Test
    fun `deletePost success`() {
        every { soPostService.deletePost(any()) } returns Unit
        
        mockMvc.perform(
            delete("/so/posts/1")
        ).andExpect(status().isNoContent)
        
        verify { soPostService.deletePost(1) }
    }
    
    @Test
    fun `deletePost throw NoDataFoundException`() {
        every { soPostService.deletePost(any()) } throws NoDataFoundException()
        
        mockMvc.perform(
            delete("/so/posts/1")
        ).andExpect(status().isNotFound)
        
        verify { soPostService.deletePost(1) }
    }
    
    @Test
    fun `addHiddenContent success`() {
        every { soPostService.addHiddenContent(any(), any(), any(), any()) } returns Unit
        
        mockMvc.perform(
            post("/so/posts/{id}/hidden-content", 1)
                .contentType(MediaType.APPLICATION_JSON)
                //language=json
                .content("{\n  \"question\": \"question-1\",\n  \"answer\": \"answer-1\",\n  \"content\": \"content-1\"\n}")
        ).andExpect(status().isCreated)
        
        verify { soPostService.addHiddenContent(1L, "question-1", "answer-1", "content-1") }
    }
    
    @Test
    fun `addHiddenContent throw DataConflictException`() {
        every { soPostService.addHiddenContent(any(), any(), any(), any()) } throws DataConflictException()
        
        mockMvc.perform(
            post("/so/posts/{id}/hidden-content", 1)
                .contentType(MediaType.APPLICATION_JSON)
                //language=json
                .content("{\n  \"question\": \"question-1\",\n  \"answer\": \"answer-1\",\n  \"content\": \"content-1\"\n}")
        ).andExpect(status().isConflict)
        
        verify { soPostService.addHiddenContent(1L, "question-1", "answer-1", "content-1") }
    }
}
