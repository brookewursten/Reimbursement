package com.reimbursement.repo;

import java.util.ArrayList;

public interface DaoContract<T,I> {


	/*
	 * 
	 * @author Revature
	 *
	 * @param <T> Type of model
	 * @param <I> Primary key for model
	 * 
	 *This will create a contract for all dao classes to follow.
	 */             
	 //@return A list of all instances in the db
	ArrayList<T> findAll();

	/**
	 * 
	 * @param i primary key of the instance
	 * @return the instance with the same primary key
	 */
	T findById(I i);

	/**
	 * 
	 * @param t the instance to update
	 * @return the updated instance
	 */
	void update(T t);

	/**
	 * 
	 * @param t the instance to create
	 * @return the created instance
	 */
	void create(T t);

	/**
	 * 
	 * @param i the primary key of the instance to be removed
	 * @return how many were removed [0 if failure, 1 if success]
	 */
	void delete(I i);
}
