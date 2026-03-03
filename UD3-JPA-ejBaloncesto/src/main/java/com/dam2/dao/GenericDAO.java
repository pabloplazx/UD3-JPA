package com.dam2.dao;

public interface GenericDAO<T,V> {
	
	void create(T object);
	T get(V key);
	void remove(T object);
	void update(T object);

}
