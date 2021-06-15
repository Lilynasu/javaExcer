package model;

import java.util.HashMap;
import java.util.Map;


public class Cart {
	
	private Map<String, CartItem> items; 

	public Cart() {
		this.items = new HashMap<>();
	}
	
	public Map<String, CartItem> getItems() {
		return items;
	}

	public void add(Book book) {
		String isbn = book.getIsbn();
		CartItem item = this.items.get(isbn);
		if(item == null) {
			item = new CartItem(book,1);
		}else {
			int amount = item.getAmount();
			amount++;
			item.setAmount(amount);
		}
		this.items.put(isbn, item);
	}
	
	public int getSubTotal() {
		int total = 0;
		for(String isbn:this.items.keySet()) {
			CartItem item = items.get(isbn);
			int price = item.getBook().getPrice();
			int amount = item.getAmount();
			total += price * amount;
		}
				
		return total;
	}

}

