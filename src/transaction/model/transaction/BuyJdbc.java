package transaction.model.transaction;

import java.util.List;

/**
 *
 * @author Khanza
 */
public interface BuyJdbc {

    public abstract List<ResponseListTableBuy> selectBuys(String search);

    public abstract void insertBuy(Buy buy);

    public abstract void updateBuy(Buy buy);
    
    public abstract void deleteBuy(Long id);

}
