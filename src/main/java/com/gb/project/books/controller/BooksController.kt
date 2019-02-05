package com.gb.project.books.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

import com.gb.project.books.model.Book


@RestController
class BooksController {

    val counter = AtomicLong()
	
    @GetMapping("/books")
    fun addBook(@RequestParam(value = "title", defaultValue = "Book title exaple") name: String) =
            Book(counter.incrementAndGet(), name, "Book description example", "9781617293290", "BR")

}