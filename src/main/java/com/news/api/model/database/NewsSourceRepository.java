package com.news.api.model.database;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface NewsSourceRepository extends JpaRepository<NewsSource, Long> {

}
