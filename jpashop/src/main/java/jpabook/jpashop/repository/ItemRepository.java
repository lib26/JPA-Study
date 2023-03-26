package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            // 신규 아이템 저장. 신규 아이템은 엔티티 객체는 id(PK) 필드값이 없다. persist 수행해야 생김.
            em.persist(item);
        } else {
            em.merge(item); // 이미 있던 아이템 수정
            /**
             * merge는 비영속 상태인 엔티티의 변경된 값을 영속 상태인 엔티티에 밀어 넣는다.
             * 즉, 비영속으로 넘어온 엔티티의 식별값을 통해서 기존 영속 상태인 엔티티를 가져온 뒤 변경된 비영속 엔티티의 값으로 merge
             */
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

}
