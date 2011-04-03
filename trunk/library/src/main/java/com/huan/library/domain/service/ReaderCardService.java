package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.reader.ReaderCard;

/**
 * 读者借阅证service
 * @author huan
 * @time 2011-3-15 上午10:12:49
 */
public interface ReaderCardService {
	/**
	 * 增加或是修改读者借阅证
	 * @param readerCard
	 * @return
	 * @throws Exception
	 */
	public ReaderCard addOrModifyReaderCard(ReaderCard readerCard) throws Exception;
	
	/**
	 * 删除读者借阅证
	 * @param readerCard
	 * @throws Exception
	 */
	public void removeReaderCard(ReaderCard readerCard) throws Exception;
	
	/**
	 * 根据Id查找ReaderCard
	 * @param readerCardId
	 * @return
	 */
	public ReaderCard findReaderCardById(Long readerCardId) throws Exception;
	
	/**
	 * 查找所有的ReaderCard
	 * @return
	 * @throws Exception
	 */
	public List<ReaderCard> findAllReaderCards() throws Exception;

   
}
