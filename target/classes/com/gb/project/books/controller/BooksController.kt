package com.gb.project.books.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;

import com.gb.project.books.model.Book


@RestController
class BooksController {

    val counter = AtomicLong()
	
    @GetMapping("/book")
    fun addBook(@RequestParam(value = "title", defaultValue = "Book title example") name: String) =
            Book(counter.incrementAndGet(), name, "Book description example", "9781617293290", "BR")
	
	@GetMapping("/books")
    fun getBooks(){
		val conn = Jsoup.connect("https://kotlinlang.org/docs/books.html").method(Method.GET)
		val resp = conn.execute()
		println(resp.body())
	}

}