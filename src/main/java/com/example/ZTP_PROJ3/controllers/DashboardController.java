package com.example.ZTP_PROJ3.controllers;


import com.example.ZTP_PROJ3.beans.Book;
import com.example.ZTP_PROJ3.exceptions.NotFoundException;
import com.example.ZTP_PROJ3.requests.CreateBookRequest;
import com.example.ZTP_PROJ3.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

//    public DashboardController(DashboardService dashboardService) {
//        this.dashboardService = dashboardService;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBooks(){
        return dashboardService.getAllBooks();
    }

    @RequestMapping (method = RequestMethod.POST)
    public List<Book> addNewBook(@RequestBody CreateBookRequest createBookRequest){
        return dashboardService.addBook( createBookRequest.getTitle(), createBookRequest.getAuthor(), createBookRequest.getYear());
    }
    @RequestMapping (value = "/{bookId}", method = RequestMethod.DELETE)
    public List<Book> deleteBook(@PathVariable String bookId) throws NotFoundException {
        return dashboardService.deleteBookById(bookId);
    }

    @RequestMapping (value = "/{bookId}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable String bookId) throws NotFoundException {
        return dashboardService.getBookById(bookId);
    }
}
