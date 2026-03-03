package com.dam2.dao;

public interface GenericDao<T, K> {
	
	void create(T object);
	T get(K key);
	void remove(T object);
	void update(T object);

}
