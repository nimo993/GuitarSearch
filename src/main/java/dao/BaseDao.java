package dao;

import java.util.List;

public interface BaseDao<T> {
	
	public List<T> findAll();
	public T getById();
	public int insert();
	public boolean update();
	public boolean delete();

}
