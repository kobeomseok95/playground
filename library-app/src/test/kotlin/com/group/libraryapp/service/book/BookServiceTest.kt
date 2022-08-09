package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.JavaBook
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.IllegalArgumentException

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository,
) {

    @AfterEach
    fun tearDown() {
        bookRepository.deleteAll()
        userRepository.deleteAll()
    }

    @Test
    fun saveBookTest() {

        // given
        val request = BookRequest("이상한 나라의 앨리스")

        // when
        bookService.saveBook(request)

        // then
        bookRepository.findAll()
            .also {
                assertThat(it).hasSize(1)
                assertThat(it[0].name).isEqualTo(request.name)
        }
    }

    @Test
    fun loanBookTest() {

        // given
        val savedBook = bookRepository.save(Book("예제 책"))
        val savedUser = userRepository.save(User("고범석", null))
        val request = BookLoanRequest("고범석", "예제 책")

        // when
        bookService.loanBook(request)

        // then
        userLoanHistoryRepository.findAll().also {
            assertThat(it).hasSize(1)
            assertThat(it[0].bookName).isEqualTo(savedBook.name)
            assertThat(it[0].user.id).isEqualTo(savedUser.id)
            assertThat(it[0].isReturn).isFalse()
        }
    }

    @Test
    fun loanBookFailTest() {

        // given
        val savedBook = bookRepository.save(Book("예제 책"))
        val savedUser = userRepository.save(User("고범석", null))
        userLoanHistoryRepository.save(UserLoanHistory(savedUser, savedBook.name, false))
        val request = BookLoanRequest("고범석", "예제 책")

        // when, then
        assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.apply {
            assertThat(this.message).isEqualTo("진작 대출되어 있는 책입니다")
        }
    }

    @Test
    fun returnBookTest() {

        // given
        val savedBook = bookRepository.save(Book("예제 책"))
        val savedUser = userRepository.save(User("고범석", null))
        userLoanHistoryRepository.save(UserLoanHistory(savedUser, savedBook.name, false))
        val request = BookReturnRequest(savedUser.name, savedBook.name)

        // when
        bookService.returnBook(request)

        // then
        userLoanHistoryRepository.findAll().apply {
            assertThat(this).hasSize(1)
            assertThat(this[0].isReturn).isTrue
        }
    }
}
