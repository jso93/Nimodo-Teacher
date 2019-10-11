package interfaces;

import java.util.List;

public interface ICrudDao<Object> {
    public boolean Create(Object object);
    public List<Object> Read();
    public boolean Update(Object object_actual, Object object_nuevo);
    public boolean Delete(Object object);
}
