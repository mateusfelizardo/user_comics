package com.api.user_comics.repository;

import com.api.user_comics.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic,Long> {
}
