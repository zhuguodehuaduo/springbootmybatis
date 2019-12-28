package com.lry.springbootmybatis.handler;

import com.lry.springbootmybatis.dao.StudentDao;
import com.lry.springbootmybatis.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author liurenyi
 * @create 2019--12--25--10:45
 */
@Controller
public class handler {

    @Autowired
    private StudentDao dao;

    @RequestMapping("/selectAll")
    public String selectAll(Model model){
        model.addAttribute("list",dao.selectAll());
        return "index";
    }

    @RequestMapping("/toinsert")
    public String toinsert(){
        return "insert";
    }

    @RequestMapping("/insert")
    public String insert(HttpServletRequest req){
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Student student=new Student();
        student.setName(name);
        student.setPassword(password);
        dao.insert(student);
        return "redirect:/selectAll";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
       dao.delete(id);
        return "redirect:/selectAll";
    }

    @RequestMapping("/selectAllByid/{id}")
    public String selectAllByid(@PathVariable int id,Map<String,Object> map){
        map.put("stu",dao.selectAllByid(id));
        return "update";
    }

    @RequestMapping("/update")
    public String update(Student student){
        dao.update(student);
        return "redirect:/selectAll";
    }



}
