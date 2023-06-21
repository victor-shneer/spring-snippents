package patterns.structure.composite;

import lombok.Data;

@Data
public class Product implements Box {
    protected final String title;
    protected final double price;

    @Override
    public double calculatePrice() {
        return getPrice();
    }
}
