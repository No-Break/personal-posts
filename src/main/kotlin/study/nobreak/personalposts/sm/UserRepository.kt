package study.nobreak.personalposts.sm

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<SmUser, Long> {
    fun findByUserId(userId: String): SmUser
}