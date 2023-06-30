package transaction.model.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import transaction.model.item.Item;
import transaction.model.supplier.Supplier;

/**
 *
 * @author Khanza
 */
public class Buy {

    private Long id;
    private Supplier supplier;
    private Item item;
    private BigDecimal buyPrice;
    private LocalDateTime date;

    public Buy() {
        supplier = new Supplier();
        item = new Item();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
