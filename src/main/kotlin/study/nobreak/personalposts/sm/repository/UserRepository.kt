package study.nobreak.personalposts.sm.repository

import org.springframework.data.repository.CrudRepository
import study.nobreak.personalposts.sm.domain.SmUser

interface UserRepository : CrudRepository<SmUser, Long> {
    fun findByUserId(userId: String): SmUser
}