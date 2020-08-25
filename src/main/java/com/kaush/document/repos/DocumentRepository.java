package com.kaush.document.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kaush.document.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
