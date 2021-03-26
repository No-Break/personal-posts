package study.nobreak.personalposts.sm

import org.springframework.data.repository.CrudRepository

interface UserRepository:CrudRepository<smUser,Long>{
    fun findByUserId(userId:String):smUser
}