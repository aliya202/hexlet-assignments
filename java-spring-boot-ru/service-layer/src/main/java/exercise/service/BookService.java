package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper bookMapper;


    public List<BookDTO> getAll() {
        var posts = repository.findAll();
        var result = posts.stream()
                .map(bookMapper::map)
                .toList();
        return result;
    }

    public BookDTO create(BookCreateDTO postData) {
        var post = bookMapper.map(postData);
        repository.save(post);
        var bookDTO = bookMapper.map(post);
        return bookDTO;
    }

    public BookDTO findById(Long id) {
        var post = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var bookDTO = bookMapper.map(post);
        return bookDTO;
    }

    public BookDTO update(BookUpdateDTO postData, Long id) {
        var post = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        bookMapper.update(postData, post);
        repository.save(post);
        var bookDTO = bookMapper.map(post);
        return bookDTO;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}
