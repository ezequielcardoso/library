package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.reader.Reader;
import com.huan.library.web.view.ReaderView;

/**
 * 读者业务层
 * @author huan
 * @time  2011-3-14 下午02:01:44
 */
public interface ReaderService {
	/**
	 * 增加或是修改读者
	 * @param reader
	 * @
	 */
	public Reader addOrModifyReader(Reader reader) ;
	
	/**
	 * 删除读者
	 * @param reader
	 * @
	 */
	public void removeReader(Reader reader) ;
	
	/**
	 * 根据借阅证号查找Reader
	 * @param readerId
	 * @return
	 */
	public Reader findReaderByBarCode(String barCode) ;
	/**
	 * 
	 * @param readerId
	 * @return
	 * @
	 */
	public Reader findReaderById(Long readerId) ;
	/**
	 * 
	 * @param readerView
	 * @return
	 * @
	 */
    public List<Reader> findReaders(ReaderView readerView) ;
    /**
     * 导出Excel
     * @param rootDir
     * @param readerView
     * @return
     */
	public String exportExcel(String rootDir, ReaderView readerView) ;
    /**
     * 读者借阅信息导出Excel
     * @param rootDir
     * @param readerView
     * @return
     */
	public String exportReaderBorrowedExcel(String rootDir,ReaderView readerView);

}
