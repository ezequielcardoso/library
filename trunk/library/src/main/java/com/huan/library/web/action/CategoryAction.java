package com.huan.library.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.service.CategoryService;
import com.opensymphony.xwork2.Action;
/**
 * 图书分类显示层
 * @author huan
 * @time  2011-3-13 下午03:49:09
 */
@Controller("categoryAction")
public class CategoryAction extends BaseActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Category category;
	
	@Autowired
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * 添加图书分类
	 * @return
	 */
	public String savePress()  {
		try {
		categoryService.addOrModifyCategory(category);
		} catch (Exception e) {
		  e.printStackTrace();
		 return Action.ERROR;
		}
		 return Action.SUCCESS;
	}
	
	/**
	 * 显示修改图书分类
	 * @return
	 */
	public String showModifyCategory() {
		try {
			  //catogory会不会为空
	          Category categoryMidify = categoryService.findCategoryById(category.getCategoryId());
			} catch (Exception e) {
				e.printStackTrace();
				return Action.ERROR;
			}
		return "showModifyCategory";
	}
	
	/**
	 * 修改图书分类
	 * @return
	 * @throws Exception
	 */
	public String modifyCategory()  {
		try {
		   //category会不会为空
		   categoryService.addOrModifyCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 删除分类
	 * @return
	 */
	public String deleteCategory() {
		try {
			//注意一下会不会为null
		   categoryService.removeCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	
	/**
	 * 查找所有的分类
	 * @return
	 * @throws Exception
	 */
	public String findCategorys()  {
		try {
		List<Category> categoryList = categoryService.findAllCategorys();
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}



}
