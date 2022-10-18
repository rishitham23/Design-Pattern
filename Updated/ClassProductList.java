package designpatterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ClassProductList extends ArrayList<Product> {

	private ProductIterator productIterator;

	private Product product;

	private ReminderVisitor reminderVisitor;

	public void accept(NodeVisitor visitor) {

	}
	public void readProductFromFile() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("/Users/vhps/Desktop/designpatterns/src/ProductInfo.txt/"));
		String line = null;
		while ((line = br.readLine()) != null) {
			Product product = new Product(line, 0);
			add(product);
		}
	}

}
