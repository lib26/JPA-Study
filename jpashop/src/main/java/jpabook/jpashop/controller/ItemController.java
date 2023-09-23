package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping(value = "/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm()); // new BookForm()은 View에 객체 바인딩? 같은 느낌
        return "items/createItemForm";
    }

    @PostMapping(value = "/items/new")
    public String create(BookForm form) {

        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book); // saveItem은 persist 혹은 merge를 한다
        return "redirect:/items";
    }

    /**
     * 상품 목록 조회
     */
    @GetMapping(value = "/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    /**
     * 상품 수정 폼
     */
    @GetMapping(value = "/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {

        // @Transactional 밖으로 나온 item 객체는 준영속 엔티티가 된다. 따라서 변경 감지가 안된다.
        Book item = (Book) itemService.findOne(itemId);

        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form", form); // 이런식으로 엔티티를 직접 넘기지 않고 dto를 넘기도록 하자
        return "items/updateItemForm";
    }

    /**
     * 상품 수정 -> merge
     * merge는 비영속 상태인 엔티티의 변경된 값을 영속 상태인 엔티티에 밀어 넣는다.
     * 즉, 비영속으로 넘어온 엔티티의 식별값을 통해서 기존 영속 상태인 엔티티를 가져온 뒤 변경된 비영속 엔티티의 값으로 merge
     */
    //@PostMapping(value = "/items/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") BookForm form) {

        Book book = new Book(); // 이 인스턴스는 준영속 상태이다. 즉, 영속성 컨텍스트가 관리하지 않는 엔티티다.
        book.setId(form.getId()); // 식별자(PK)를 설정해준다 한들 영속성 컨텍스트의 지원을 받을 수 없고 데이터를 수정해도 변경 감지 기능은 동작하지 않는다.
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book); // saveItem은 persist 혹은 merge를 한다
        return "redirect:/items";
    }

    /**
     * 권장 코드
     * 상품 수정 -> 변경 감지
     */
    @PostMapping(value = "/items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm form) {

        itemService.updateItem(itemId, form.getName(), form.getPrice(), form.getStockQuantity());
        return "redirect:/items";
    }
}






