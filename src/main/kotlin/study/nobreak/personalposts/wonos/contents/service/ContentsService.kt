package study.nobreak.personalposts.wonos.contents.service

interface ContentsService {
    fun searchAllContents(title: String, mainText: String, writer: String)
}