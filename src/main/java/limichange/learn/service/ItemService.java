package limichange.learn.service;

import limichange.learn.Item;
import limichange.learn.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public void insertTwo() {
        Item item1 = new Item();
        item1.setAge(1);
        item1.setSize(20);

        Item item2 = new Item();
        item2.setAge(12);
        item2.setSize(20);

        this.itemRepository.save(item1);
        this.itemRepository.save(item2);
    }
}
