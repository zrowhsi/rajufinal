package np.com.ishworb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import np.com.ishworb.app.entity.ItemDetails;
@Repository
public interface ItemRepository extends JpaRepository<ItemDetails,Integer>{

}
