package github.devokado.ecommerce.catalog.domain.product;

import github.devokado.ecommerce.common.domain.BaseEntity;

public class Tag extends BaseEntity {
    private Integer id;
    private String title;

    public Tag(String title) {
        this.title = title;
    }

    public Integer id() {
        return id;
    }

    public String title() {
        return title;
    }
}
