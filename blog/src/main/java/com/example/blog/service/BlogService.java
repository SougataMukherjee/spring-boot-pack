package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final List<Blog> blogs = Arrays.asList(
            new Blog(1, "First Blog", "Short description of first blog", "Full content of first blog", "/images/blog-1.jpg"),
            new Blog(2, "Second Blog", "Short description of second blog", "Full content of second blog", "/images/blog-2.jpg"),
            new Blog(3, "Third Blog", "Short description of third blog", "Full content of third blog", "/images/blog-3.jpg")
    );

    public List<Blog> getAllBlogs() {
        return blogs;
    }

    public Optional<Blog> getBlogById(int id) {
        return blogs.stream().filter(b -> b.getId() == id).findFirst();
    }
}
