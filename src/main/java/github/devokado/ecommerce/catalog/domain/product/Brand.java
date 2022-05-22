package github.devokado.ecommerce.catalog.domain.product;

import github.devokado.ecommerce.common.domain.BaseEntity;

public class Brand extends BaseEntity {
    private Integer id;
    private String name;

    public Brand(String name) {
        this.name = name;
    }

    public Integer id() {
        return id;
    }

    public String name() {
        return name;
    }
}
