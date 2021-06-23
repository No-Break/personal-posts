package study.nobreak.personalposts.wonos.contents.service

interface ContentsService {

    fun searchAllContents()

    fun createContents(title: String, mainText: String, writer: String)

    fun deleteContents(id: Int)

    fun updateContents(id: Int)
}