package limichange.learn.controller;

import limichange.learn.Item;
import limichange.learn.repository.ItemRepository;
import limichange.learn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/all")
    public List<Item> all() {
        return this.itemRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Item Id(@PathVariable("id") Integer id) {
        return this.itemRepository.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public String del(@PathVariable("id") Integer id) {
        Item item = new Item();
        item.setId(id);
        this.itemRepository.delete(item);
        return "ok";
    }

    @PutMapping(value = "/{id}")
    public Item update (@PathVariable("id") Integer id, Item item) {
        item.setId(id);
        item.setSize(item.getSize());
        item.setAge(item.getAge());
        this.itemRepository.save(item);
        return this.itemRepository.findOne(id);
    }

    @PostMapping(value = "/")
    public String add(@Valid Item item, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorString = bindingResult.getFieldError().getDefaultMessage();
            System.out.println(errorString);
            return errorString;
        }

        item.setAge(item.getAge());
        item.setSize(item.getSize());
        this.itemRepository.save(item);
        return "ok";
    }

    @PostMapping(value = "/insertTwo")
    public String insertTwo() {
        this.itemService.insertTwo();
        return "ok";
    }
}
