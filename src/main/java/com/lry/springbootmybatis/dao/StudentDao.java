package com.lry.springbootmybatis.dao;

import com.lry.springbootmybatis.po.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/** @Mapper 标注这是一个映射器接口
 * @author liurenyi
 * @create 2019--12--25--10:43
 */
@Repository
@Mapper
public interface StudentDao {
    @Select("select * from student")
    List<Student> selectAll();
    @Select("select * from student where id=#{id}")
    Student selectAllByid(int id);
    @Insert("insert into student(name,password)VALUES(#{name},#{password})")
    int insert(Student student);
    @Delete("delete from student where id=#{id} ")
    int delete(int id);
    @Update("update student set name=#{name},password=#{password} where id=#{id}")
    int update(Student student);
}
