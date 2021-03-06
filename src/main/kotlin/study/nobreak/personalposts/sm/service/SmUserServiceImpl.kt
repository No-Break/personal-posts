package study.nobreak.personalposts.sm.service

import org.springframework.stereotype.Component
import study.nobreak.personalposts.sm.SmUser
import study.nobreak.personalposts.sm.repository.UserRepository
import java.security.MessageDigest

@Component
class SmUserServiceImpl(val userRepository: UserRepository) : SmUserService {

    override fun addUser(userId: String, password: String): SmUser {

        val cryptoPass: String = crypto(password)
        val user = userRepository.save(SmUser(userId, cryptoPass))
        return user
    }

    override fun checkUser(userId: String, password: String): SmUser {

        val cryptoPass: String = crypto(password)
        val user = userRepository.findByUserId(userId)

        val user_pass = user.password
        if (cryptoPass.equals(user_pass)) {
            return user
        }
        return user
    }

    fun crypto(ss: String): String {
        val sha = MessageDigest.getInstance("SHA-256")
        val hexa = sha.digest(ss.toByteArray())
        val crypto_str = hexa.fold("", { str, it -> str + "%02x".format(it) })
        return crypto_str
    }
}