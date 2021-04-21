package study.nobreak.personalposts.wonos.contents.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import study.nobreak.personalposts.wonos.contents.domain.Contents

@Repository
interface ContentsRepository : JpaRepository<Contents, Int> {
}