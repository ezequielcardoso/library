package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.reader.ReaderCard;
import com.huan.library.domain.service.ReaderCardService;
import com.huan.library.infrastructure.persistence.ReaderCardDao;
import com.huan.library.web.view.ReaderCardView;

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
			throw new Exception(e);
		}
		return readerCardCopy;
	}

	public void removeReaderCard(ReaderCard readerCard) throws Exception {
		try {
			readerCardDao.delete(readerCard);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public ReaderCard findReaderCardById(Long readerCardId) throws Exception {
		ReaderCard readerCard = new ReaderCard();
		try {
			readerCard = readerCardDao.selectById(readerCardId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return readerCard;
	}

	public List<ReaderCard> findReaderCards(ReaderCardView readerCardView)
			throws Exception {
		List<ReaderCard> readerCards = new ArrayList<ReaderCard>();
		try {
			readerCards = readerCardDao.selectReaderCards(readerCardView);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return readerCards;
	}
}
