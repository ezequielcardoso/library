package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.reader.ReaderCard;
import com.huan.library.domain.service.ReaderCardService;
import com.huan.library.infrastructure.persistence.ReaderCardDao;

/**
 * 读者借阅证service实现
 * 
 * @author huan
 * @time 2011-3-15 上午10:19:03
 */
@Service("readerCardService")
public class ReaderCardServiceImpl implements ReaderCardService {

	@Autowired
	private ReaderCardDao readerCardDao;

	public void setReaderCardDao(ReaderCardDao readerCardDao) {
		this.readerCardDao = readerCardDao;
	}

	public ReaderCard addOrModifyReaderCard(ReaderCard readerCard)
			throws Exception {
		ReaderCard readerCardCopy = new ReaderCard();
		try {
			readerCardCopy = readerCardDao.saveOrUpdate(readerCard);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return readerCardCopy;
	}

	public void removeReaderCard(ReaderCard readerCard) throws Exception {
		try {
			readerCardDao.delete(readerCard);
		} catch (Exception e) {
		   e.printStackTrace();
		}
	}

	public ReaderCard findReaderCardById(int readerCardId) throws Exception {
		ReaderCard readerCard = new ReaderCard();
		try {
			readerCard = readerCardDao.get(readerCardId);
		} catch (Exception e) {
		  e.printStackTrace();
		  return null;
		}
		return readerCard;
	}

	public List<ReaderCard> findAllReaderCards() throws Exception {
		List<ReaderCard> readerCards = new ArrayList<ReaderCard>();
		try {
			readerCards = readerCardDao.selectMaxTs();	
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
		return readerCards;
	}
}
