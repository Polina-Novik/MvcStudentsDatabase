package by.novik.controller;


import by.novik.service.TestService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequiredArgsConstructor
@Controller
@RequestMapping("hello")
@Slf4j
public class HelloController {
    private final TestService service;



    //аналог тго что обычно делаем через сервлет
    @GetMapping
    public String hello(HttpSession session, Model model) { //в скобках чтобы добавить атрибут
        log.info("hello from endpoint");
        session.setAttribute("test","ahahahaha");
        model.addAttribute("second","hihihihihi"); //модель например когда атрибут хранить не надо типо добавить время
        return "index2.jsp"; //никаких requestdispatcher  и тд
    }
    @GetMapping("user/{id}")
    public String getUserById(@PathVariable int id) { //в скобках - число в пути сохрнаить в переменную метода
        //можно было int id, но если доб () то Integer+ id может быть а может и не быть (@PathVariable (required = false) Integer id)
        String user=service.getUserById(id);
        log.info("we try to find user with id: {}", id);
        return "user.jsp";
    }
    @GetMapping("client")
    public String getClient(@RequestParam ("age") int age) {
        log.info("we want to check client with age: {}", age);
        return "user.jsp"; //http://localhost:8080/hello/client?age=20 после вопроса request parameter
    }
}
