package au.usyd.elec5619.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import au.usyd.elec5619.dao.ItemDao;
import au.usyd.elec5619.domain.Item;
import junit.framework.TestCase;
@Service(value="itemservice")
//@Transactional

public class ItemService {
	@Autowired
	private ItemDao itemDao;
	
	public void saveItem(Item item) {		
		itemDao.saveItem(item);
    }

	public void addItem(Item item) {		
		itemDao.addItem(item);
    }
    
	public List<Item> getAllItem() {
	     return itemDao.getAllItem();
	}
	
	public Item getItem(int id) {
	     return itemDao.getItem(id);
	}

	public void deleteItem(int id) {		
		itemDao.deleteItem(id);
    }

	public void updateItem(Item item) {		
		itemDao.updateItem(item);
    }   
    
}