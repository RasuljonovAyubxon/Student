package uz.pdp.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.student.dao.StudentDao;
import uz.pdp.student.model.Student;

import java.util.List;

@Controller
@RequestMapping("/Student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentDao studentDao;

    @GetMapping
    public String create(Student student){
          studentDao.cerate(student);
        return "Student";

    }
    @GetMapping
    public String read(Model model) {
        List<Student> student = studentDao.read();
        model.addAttribute("students", student);
        return "Student";

    }

    @PostMapping("/edit")
    public String update(Student  student) {
        studentDao.update(student);
        return "redirect:/Student";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        studentDao.delete(id);
        return "redirect:/Student";
    }
}