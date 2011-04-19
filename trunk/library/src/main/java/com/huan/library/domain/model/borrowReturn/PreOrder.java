package com.huan.library.domain.model.borrowReturn;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.BookState;
import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.domain.model.reader.ReaderUnits;
/**
 * 图书预约
 * @author Administrator
 *
 */
@Entity
public class PreOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //主键
    
	private Date preOrderDate;       //预约日期
	private Date preOrderEndDate;    //预约到期日期
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=Book.class, cascade={CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="book")
    private Book book ;   //图书
    
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=Reader.class, cascade={CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="reader")
    private Reader reader;     //读者
   
	public PreOrder(){
		super();
	}
	
	public PreOrder(Long id,Date preOrderDate, Date preOrderEndDate,Long bookId,String bookNo,String bookBarCode,String bookName,String location,
			String firstCategoryId,String firstCategoryCode,String firstCategoryName,String bookStateId,String bookStateName,
			Long readerId,String cardNo,String readerBarCode,String readerName,Long unitId,String unitCode,String unitName,
			Long readerTypeId,String readerCateCode,String readerCateName){
		this.id = id ;
	    this.preOrderDate = preOrderDate;
	    this.preOrderEndDate = preOrderEndDate;
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookNo(bookNo);
		book.setBarCode(bookBarCode);
		book.setBookName(bookName);
		book.setLocation(location);
		
		Category firstCategory = new Category();
		firstCategory.setItemId(firstCategoryId);
		firstCategory.setItemCode(firstCategoryCode);
		firstCategory.setItemName(firstCategoryName);
		book.setFirstCategory(firstCategory);
		
		BookState bookState = new BookState();
		bookState.setItemId(bookStateId);
		bookState.setItemName(bookStateName);
        book.setBookState(bookState);
        
        this.setBook(book);
        
        Reader reader = new Reader();
        reader.setId(readerId);
        reader.setCardNo(cardNo);
        reader.setBarCode(readerBarCode);
        reader.setReaderName(readerName);
        
        ReaderUnits readerUnits = new ReaderUnits();
		readerUnits.setUnitId(unitId);
		readerUnits.setUnitcode(unitCode);
		readerUnits.setUnitName(unitName);
		reader.setReaderUnits(readerUnits);
		
		ReaderType readerType = new ReaderType();
		readerType.setId(readerTypeId);
        readerType.setReaderCateCode(readerCateCode);
        readerType.setReaderCateName(readerCateName);
        reader.setReaderType(readerType);
        this.setReader(reader);
        
 	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPreOrderDate() {
		return preOrderDate;
	}

	public void setPreOrderDate(Date preOrderDate) {
		this.preOrderDate = preOrderDate;
	}

	public Date getPreOrderEndDate() {
		return preOrderEndDate;
	}

	public void setPreOrderEndDate(Date preOrderEndDate) {
		this.preOrderEndDate = preOrderEndDate;
	}


	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}
  
	
}
