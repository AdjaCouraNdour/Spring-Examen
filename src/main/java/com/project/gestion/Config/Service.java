package com.project.gestion.Config;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service<T> {

    T findById(Long id);

    List<T> findAll();

    Page<T> findAllPageable(Pageable pageable);
}
