package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional // 변경
    public void saveItem(Item item) {
        itemRepository.save(item);  // save은 persist 혹은 merge를 한다
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    /**
     * 영속성 컨텍스트가 자동 변경.
     */
    @Transactional
    public void updateItem(Long id, String name, int price, int stockQuantity) {
        Item item = itemRepository.findOne(id); // 영속 상태인 엔티티를 가져온다.
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
        // 트랜젝션 commit 되면 변경 감지로 DB에 update 쿼리가 날라간다.

        // item.change(name, price, stockQuantity)
        // 그리고 이렇게 setter를 사용하는 것보단 엔티티에 비즈니스 메서드를 만들어서 사용하자
    }
}
