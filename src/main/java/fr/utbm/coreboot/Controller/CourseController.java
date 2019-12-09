/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coreboot.Controller;

import fr.utbm.coreboot.Entity.Course;
import fr.utbm.coreboot.Service.CourseService;
import fr.utbm.coreboot.Service.SessionService;
import fr.utbm.coreboot.Service.LocationService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping(value = "/all-course")
    public String allCourses(Model model) {
        model.addAttribute("courses", courseService.all());
        return "all-course";
    }

    @RequestMapping(value = "/add-course", method = RequestMethod.GET)
    public String addCourse() {
        return "add-course";
    }

    @RequestMapping(value = "/add-course", method = RequestMethod.POST)
    public String addCourseSubmit(HttpServletRequest request, HttpServletResponse response) {

        String code = request.getParameter("code");
        String title = request.getParameter("title");

        Course course = new Course();
        course.setCode(code);
        course.setTitle(title);
        courseService.addCourse(course);
        return "redirect:/all-course";
    }


}
