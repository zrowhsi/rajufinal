package np.com.ishworb.app.service;

import java.io.Serializable;
import java.util.List;

public interface CrudService<E> {
	void add(E entity);

	List<E> getAll();

	E getById(Serializable id);

	void delete(Serializable id);
}
