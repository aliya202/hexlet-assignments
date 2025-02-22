package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
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
import java.util.Objects;

// BEGIN
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Comment show(@PathVariable long id) {
        var comment = commentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));

        return comment;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping("/{id}") // Обновление страницы
    public Comment update(@PathVariable Long id, @RequestBody Comment data) {
        var maybeComment = commentRepository.findAll().stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst();
        if (maybeComment.isPresent()) {
            var comment = maybeComment.get();
            comment.setBody(data.getBody());
        } else {
            throw new ResourceNotFoundException("Comment with id " + id + " not found");
        }
        return data;
    }

    // END

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        commentRepository.deleteById(id);
    }

}
// END
