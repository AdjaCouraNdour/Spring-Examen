package com.project.gestion.Config.Impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gestion.Config.Service;
import com.project.gestion.utils.exceptions.EntityNotFoundExecption;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class IService<T, R extends JpaRepository<T, Long>> implements Service<T> {

    protected final R repository;


    @Override
    public T findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundExecption("Entity not found"));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<T> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
