package exercise.controller;

import java.util.List;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> index() {
        return bookService.getAll();
    }
    // END

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    BookDTO create(@Valid @RequestBody BookCreateDTO productData) {

        return bookService.create(productData);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO show(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    BookDTO update(@RequestBody @Valid BookUpdateDTO bookUpdateDTO, @PathVariable Long id) {
        return bookService.update(bookUpdateDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void destroy(@PathVariable Long id) {
        bookService.delete(id);
    }
    // END
}
