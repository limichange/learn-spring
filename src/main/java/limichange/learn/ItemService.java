package limichange.learn;

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
        item1.setCupSize("C");

        Item item2 = new Item();
        item2.setAge(12);
        item2.setCupSize("D");

        this.itemRepository.save(item1);
        this.itemRepository.save(item2);
    }
}
