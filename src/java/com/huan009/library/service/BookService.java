package com.huan009.library.service;

import com.huan009.library.domain.Book;

public interface BookService {
	
	/**
	 * ����
	 * @param book
	 */
	public void save(Book book);
	
	/**
	 * ��ҳ��ѯ
	 * @param condition
	 * @param first
	 * @param max
	 */
    public void findAll(String condition,int first,int max);
}
