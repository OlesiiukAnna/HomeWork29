package home;

import home.model.Message;
import home.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MessageController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping
    public String add(@RequestParam String title, @RequestParam String text, Map<String, Object> model) {
        Message message = new Message(title, text);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "add";
    }
}
