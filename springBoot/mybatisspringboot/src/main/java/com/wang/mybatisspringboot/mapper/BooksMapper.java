package com.wang.mybatisspringboot.mapper;

import com.wang.mybatisspringboot.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BooksMapper {

    public Books selectBookById(@Param("bookID") int id);


}
