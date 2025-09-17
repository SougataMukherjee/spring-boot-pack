package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable int id, Model model) {
        Blog blog = blogService.getBlogById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog id:" + id));
        model.addAttribute("blog", blog);
        return "blog-details";
    }
}
