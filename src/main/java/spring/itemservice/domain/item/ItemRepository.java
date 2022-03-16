package spring.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); // static
    private static long sequence = 0L; //static

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }
    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        //id를 안쓰기 때문에 실무에서 정석으로 개발은할때는 dto를 사용하는게 맞다.
        //중복 vs 명확성 일때는 명확성을 따르는것이 항상 좋은 결과를 가져다준다.
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}
