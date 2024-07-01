package com.rafexanderson5.alAboutJPA.repositories;


import com.rafexanderson5.alAboutJPA.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
}
