package com.huan.library.domain.model.reader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 借阅证状态  挂失/正常/超出数量
 * @author huan
 * @time 2011-3-8  下午06:54:00
 */
@Entity
public class ReaderCardState implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;   //主键
	private String readerCardName;  //状态名称
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,
			mappedBy="readerCardState")
	private List<ReaderCard> readerCards = new ArrayList<ReaderCard>();  //借阅证
	
	public List<ReaderCard> getReaderCards() {
		return readerCards;
	}
	public void setReaderCards(List<ReaderCard> readerCards) {
		this.readerCards = readerCards;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReaderCardName() {
		return readerCardName;
	}
	public void setReaderCardName(String readerCardName) {
		this.readerCardName = readerCardName;
	}
	

	
}
