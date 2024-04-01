package com.springboot101;

import com.springboot101.mongdb.pojo.Student;
import com.springboot101.mongdb.dao.StudentDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class MongdbApplicationTests {

    @Autowired
    private StudentDao studentDao;

    /**
     * 查询所有信息
     */
    @Test
    public void findAll() {
        List<Student> all = studentDao.findAll();
        System.out.println(all.size());
    }

    /**
     * 新增信息
     */
    @Test
    public void save() {
        Student student = new Student();
        student.setId(6l);
        student.setName("宋人头");
        studentDao.save(student);
    }

    /**
     * 修改信息
     */
    @Test
    public void update() {
        Student student = new Student();
        student.setId(2l);
        student.setName("吴很帅");
        studentDao.update(student);
    }

    /**
     * 删除信息
     */
    @Test
    public void delete() {
        studentDao.delete(3);
    }
}
