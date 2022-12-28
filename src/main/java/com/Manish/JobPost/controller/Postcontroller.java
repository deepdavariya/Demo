package com.Manish.JobPost.controller;

import com.Manish.JobPost.model.post;
import com.Manish.JobPost.repository.postrepo;
import com.Manish.JobPost.repository.searchrepo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.Decoder.Text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class Postcontroller {
    @Autowired
    postrepo repo;
    @Autowired
    searchrepo srepo;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {

        response.sendRedirect("/swagger-ui.html");

    }

    @GetMapping("/allPosts")
    public List<post> getallpost() {

        return repo.findAll();

    }

    @GetMapping("/posts/{text}")
    public List<post> searPosts(@PathVariable String text) {
        return srepo.findByText(text);

    }

    @PostMapping("/post")
    public post addpost(@RequestBody post pos) {

        return repo.save(pos);

    }

}
