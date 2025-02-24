package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping(path = "/posts")
public class PostsController {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;


    @GetMapping(path = "")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        return posts.stream()
                .map(this::toDTO)
                .toList();
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Post with id %d not found: ", id)));

        List<Comment> comments = commentRepository.findByPostId(id);
        PostDTO postDTO = toDTO(post);
        postDTO.setComments(comments.stream().map(this::toDTO).toList());

        return postDTO;
    }

    private CommentDTO toDTO(Comment comments) {
        var commentDTO = new CommentDTO();
        commentDTO.setId(comments.getId());
        commentDTO.setBody(comments.getBody());
        return commentDTO;
    }

    private PostDTO toDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setBody(post.getBody());
        dto.setTitle(post.getTitle());
        return dto;
    }

}
// END
