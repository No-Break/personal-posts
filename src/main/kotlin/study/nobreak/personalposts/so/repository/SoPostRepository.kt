package study.nobreak.personalposts.so.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.nobreak.personalposts.so.domain.SoPost

interface SoPostRepository: JpaRepository<SoPost, Long>