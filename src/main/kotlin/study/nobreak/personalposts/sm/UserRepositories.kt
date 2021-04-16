package study.nobreak.personalposts.sm

import org.springframework.data.repository.CrudRepository

interface UserRepositories : CrudRepository<SmUser, Long> {
    fun findByUserId(userId: String): SmUser
}