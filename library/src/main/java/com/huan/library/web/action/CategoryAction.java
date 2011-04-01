package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.service.CategoryService;
import com.huan.library.domain.service.impl.CategoryServiceImpl;
import com.huan.library.web.view.CategoryView;
import com.huan.library.web.view.ExtGridLoad;
import com.huan.library.web.view.ExtJsonForm;
import com.opensymphony.xwork2.Action;

/**
 * 图书分类显示层
 * 
 * @author huan
 * @time 2011-3-13 下午03:49:09
 */
@Controller("categoryAction")
public class CategoryAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoryService categoryService;
	private ExtJsonForm extJsonForm = new ExtJsonForm();
	private ExtGridLoad extGridLoad = new ExtGridLoad();
	private CategoryView categoryView = new CategoryView();
	private Category category;

	/**
	 * 跳转到主页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String categoryMain() {
		return Action.SUCCESS;
	}

	/**
	 * 查找分类
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findCategorys() {
		try {
			List<Category> categories = categoryService.findAllCategorys();
			extGridLoad.setRoot(this.convertToView(categories));
			extGridLoad.setTotalProperty(categoryView.getTotalCount());
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 添加图书分类
	 * 
	 * @return
	 */
	public String savePress() {
		categoryService = new CategoryServiceImpl();
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
	 * 
	 * @return
	 */
	public String showModifyCategory() {
		try {
			// catogory会不会为空
			Category categoryMidify = categoryService.findCategoryById(category
					.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return "showModifyCategory";
	}

	/**
	 * 修改图书分类
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modifyCategory() {
		try {
			// category会不会为空
			categoryService.addOrModifyCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 删除分类
	 * 
	 * @return
	 */
	public String deleteCategory() {
		try {
			// 注意一下会不会为null
			categoryService.removeCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public List<CategoryView> convertToView(List<Category> categories) {
		List<CategoryView> views = new ArrayList<CategoryView>();
		for (Category category : categories) {
			CategoryView view = new CategoryView();
			view.setCategoryId(category.getCategoryId());
			view.setCategoryCode(category.getCategoryCode());
			view.setCategoryName(category.getCategoryName());
//			if ("ROOT".equals(category.getCategoryCode())) {
//				view.setParentCategoryId(null);
//			}
//			view.setParentCategoryId(category.getParent().getCategoryId());

			view.setParentCategoryId("ROOT".equals(category
							.getCategoryCode()) ? null : category.getParent()
							.getCategoryId());

			views.add(view);
		}
		return views;

	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}

	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
	}

}
