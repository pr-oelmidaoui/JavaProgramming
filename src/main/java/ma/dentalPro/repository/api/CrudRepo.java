package ma.dentalPro.repository.api;

import java.util.List;

public interface CrudRepo <T, I>
{
    List<T> findAll();
    T findById( I identity );
    T save( T newElement );
    boolean update( T newValuesElement );
    boolean delete( T element );
    boolean deleteById( I identity  );
}
