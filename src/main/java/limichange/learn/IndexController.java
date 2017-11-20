package limichange.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private ItemRepository itemRepository;

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
    public Item update (@PathVariable("id") Integer id,
                        @PathParam("cup") String cup,
                        @PathParam("age") Integer age) {
        Item item = new Item();
        item.setId(id);
        item.setCupSize(cup);
        item.setAge(age);
        this.itemRepository.save(item);
        return this.itemRepository.findOne(id);
    }

    @PostMapping(value = "/")
    public Item add(@PathParam("cup") String cup, @PathParam("age") Integer age) {
        Item item = new Item();

        item.setAge(age);
        item.setCupSize(cup.trim());

        this.itemRepository.save(item);

        return item;
    }
}
