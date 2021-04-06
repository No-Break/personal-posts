package study.nobreak.personalposts.sm

import org.springframework.stereotype.Component
import java.security.MessageDigest

@Component
class SmUserServiceImpl(val userRepository: UserRepository) : SmUserService {


    override fun addUser(userId: String, password: String) {

        val cryptoPass: String = crypto(password)
        val user = userRepository.save(SmUser(userId, cryptoPass))

    }

    override fun checkUser(userId: String, password: String): SmUser {

        val cryptoPass: String = crypto(password)
        val user = userRepository.findByUserId(userId);

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