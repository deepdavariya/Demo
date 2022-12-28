package com.Manish.JobPost.repository;

import java.util.List;

import com.Manish.JobPost.model.post;

public interface searchrepo {
    List<post> findByText(String text);

}
