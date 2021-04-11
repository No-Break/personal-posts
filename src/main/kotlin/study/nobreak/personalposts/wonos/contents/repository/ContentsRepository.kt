package study.nobreak.personalposts.wonos.contents.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import study.nobreak.personalposts.wonos.contents.domain.Contents

@Repository
interface ContentsRepository : CrudRepository<Contents, Int> {
}