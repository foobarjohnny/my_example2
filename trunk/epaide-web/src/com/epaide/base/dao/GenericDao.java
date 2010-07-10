package com.epaide.base.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T, PK extends Serializable>{

	  public abstract List<T> getAll();

	  public abstract T get(PK paramPK);

	  public abstract boolean exists(PK paramPK);

	  public abstract T save(T paramT);

	  public abstract void remove(PK paramPK);
	  
	  public abstract void update(T paramT);
	
}
