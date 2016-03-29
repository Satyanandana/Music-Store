
package cs636.music.dao;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cs636.music.domain.Product;
import cs636.music.domain.Track;

/**
 * 
 * Access product and track table through this class. 
 * music2: Track objects are now all handled by JPA as
 * details of Product
 * @author Chung-Hsien (Jacky) Yu
 */
public class ProductDAO {
	DbDAO dbdao;

	/**
	 * An Data Access Object for product table and track table 
	 * @param db the database connection
	 * @throws SQLException
	 */
	public ProductDAO(DbDAO db) {
		dbdao = db;
	}
	
	/**
	 * Find a product with its tracks from given product code 
	 * @param prod_id
	 * @return the product found, return null if not found
	 */
	public Product findProductByCode(String prodCode) {
		EntityManager em = dbdao.getEM();
		TypedQuery<Product> q = 
				em.createQuery("select p from Product p where p.productCode = '" + prodCode + "'", 
						Product.class);	
		List<Product> product = q.getResultList();
		if (product.size() > 0){
			
			/*product.get(0).setTracks(findAllTracks(product.get(0).getCode()));*/
			return product.get(0);
		}
		else 
			return null;
	}

	/**
	 * Find all product in product table 
	 * Their tracks are lazily loaded if accessed in service layer.
	 * @return all products in a set
	 */
	public Set<Product> findAllProducts(){
		EntityManager em = dbdao.getEM();
		TypedQuery<Product> q = 
				em.createQuery("select p from Product p", Product.class);
		List<Product> products = q.getResultList();
		return new HashSet<Product>(products);
	}
	
	/*public Set<Track> findAllTracks(String proCode){
		EntityManager em = dbdao.getEM();
		TypedQuery<Track> q = 
				em.createQuery("select t from Track t.getProduct.productCode ='" + proCode + "'", Track.class);
		List<Track> tracks = q.getResultList();
		return new HashSet<Track>(tracks);
	}*/

}
