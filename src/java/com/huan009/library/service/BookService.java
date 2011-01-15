package com.huan009.library.service;

import com.huan009.library.domain.Book;

public interface BookService {
	
	/**
	 * ±£¥Ê
	 * @param book
	 */
	public void save(Book book);
	
	/**
	 * ∑÷“≥≤È—Ø
	 * @param condition
	 * @param first
	 * @param max
	 */
    public void findAll(String condition,int first,int max);
}
