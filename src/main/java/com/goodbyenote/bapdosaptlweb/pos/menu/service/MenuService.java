package com.goodbyenote.bapdosaptlweb.pos.menu.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goodbyenote.bapdosaptlweb.pos.model.MenuVO;

@Service
public interface MenuService {

	public List<MenuVO> list(MenuVO menu);

	public int count(MenuVO menu);

	public List<Map<String, ?>> listExcel(MenuVO menu);

	public List<Map> listExcel2(MenuVO menu);

	public List<MenuVO> detailList(MenuVO menu);
	public MenuVO getDetailSum(MenuVO menu);

	public MenuVO view(MenuVO menu);

	public List<MenuVO> viewDtl(MenuVO menu);

	/**
	 * 입력:detail->master 순
	 * 
	 * @param menu
	 * @return @
	 */
	@Transactional
	public int insertAction(MenuVO menu, HttpServletRequest request);

	/**
	 * 
	 * @param menu
	 * @return
	 */
	@Transactional
	public int insertAction(MenuVO menu);
	/**
	 * 수정:detail->master 순
	 * 
	 * @param menu
	 * @return @
	 */
	@Transactional
	public int updateAction(MenuVO menu, HttpServletRequest request);
	/**
	 * 삭제:detail->master 순
	 * 
	 * @param seq_no
	 * @return @
	 */
	@Transactional
	public int deleteAction(MenuVO menu);

	public MenuVO viewDtlSum(MenuVO adjust);
}