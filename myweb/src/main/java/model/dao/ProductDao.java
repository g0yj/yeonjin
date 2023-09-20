package model.dao;

public class ProductDao extends Dao {
	private static ProductDao d = new ProductDao();
	public static ProductDao getInstance() {return d;};
	private ProductDao() {};
	
	
}
