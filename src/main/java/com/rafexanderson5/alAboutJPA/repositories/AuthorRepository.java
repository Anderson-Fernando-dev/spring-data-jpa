package com.rafexanderson5.alAboutJPA.repositories;

import com.rafexanderson5.alAboutJPA.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
