package kitchenpos.menu.domain;

import kitchenpos.common.Name;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MenuGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Name name;

    public MenuGroup(){}

    public MenuGroup(String name) {
        this.name = new Name(name);
    }

    public MenuGroup(Long id, String name) {
        this.id = id;
        this.name = new Name(name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name.getName();
    }
}