package exercise.controller;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.service.AuthorService;
import jakarta.validation.Valid;
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

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDTO> index() {
        return authorService.getAll();
    }
    // END

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    AuthorDTO create(@Valid @RequestBody AuthorCreateDTO productData) {
        return authorService.create(productData);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO show(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO update(@RequestBody @Valid AuthorUpdateDTO bookUpdateDTO, @PathVariable Long id) {
        return authorService.update(bookUpdateDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void destroy(@PathVariable Long id) {
        authorService.delete(id);
    }
    // END
}
