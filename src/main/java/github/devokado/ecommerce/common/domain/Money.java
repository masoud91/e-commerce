package github.devokado.ecommerce.common.domain;

public class Money {
    private final Double amount;

    public Money(Double amount) {
        this.amount = amount;
    }

    public Double amount() {
        return amount;
    }
}
