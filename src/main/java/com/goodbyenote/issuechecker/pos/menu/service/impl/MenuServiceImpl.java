package com.goodbyenote.issuechecker.pos.menu.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goodbyenote.issuechecker.pos.menu.dao.MenuDAO;
import com.goodbyenote.issuechecker.pos.menu.service.MenuService;
import com.goodbyenote.issuechecker.pos.model.MenuVO;

@Service
public class MenuServiceImpl implements MenuService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MenuDAO menuDAO;

	public List<MenuVO> list(MenuVO menu) {
		System.out.println("menuDAO:"+menuDAO);
		return menuDAO.getList(menu);
	}

	public int count(MenuVO menu) {
		return menuDAO.count(menu);
	}

	public List<Map<String, ?>> listExcel(MenuVO menu) {

		return menuDAO.listExcel(menu);
	}

	public List<Map> listExcel2(MenuVO menu) {

		return menuDAO.listExcel2(menu);
	}

	public List<MenuVO> detailList(MenuVO menu) {
		return menuDAO.detailList(menu);
	}

	public MenuVO getDetailSum(MenuVO menu) {
		return menuDAO.getDetailSum(menu);
	}

	public MenuVO view(MenuVO menu) {
		return menuDAO.view(menu);
	}

	public List<MenuVO> viewDtl(MenuVO menu) {
		return menuDAO.viewDtl(menu);
	}

	/**
	 * 입력:detail->master 순
	 * 
	 * @param menu
	 * @return @
	 */
	@Transactional
	public int insertAction(MenuVO menu, HttpServletRequest request) {
		if (menuDAO.insertAction(menu) > 0) {
			String[] setle_mtd = request.getParameterValues("setle_mtd");
			String[] adju_amt = request.getParameterValues("adju_amt");
			String[] mbr_strte = request.getParameterValues("mbr_strte");
			String[] omp_sttl_amt = request.getParameterValues("omp_sttl_amt");
			String[] mbr_sttl_amt = request.getParameterValues("mbr_sttl_amt");
			logger.debug("setle_mtd.length:" + setle_mtd.length);
			for (int i = 0; i < setle_mtd.length; i++) {
				if ("".equals(adju_amt[i])) {
					adju_amt[i] = "0";
				}
				logger.debug("setle_mtd:" + setle_mtd[i]);
				menuDAO.insertDtlAction(menu);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param menu
	 * @return
	 */
	@Transactional
	public int insertAction(MenuVO menu) {
		int result = 0;
		if (menuDAO.insertAction(menu) > 0) {
			result = menuDAO.insertDtlAction(menu);
		}
		return result;
	}	
	/**
	 * 수정:detail->master 순
	 * 
	 * @param menu
	 * @return @
	 */
	@Transactional
	public int updateAction(MenuVO menu, HttpServletRequest request) {
		if (menuDAO.updateAction(menu) > 0) {
			String[] dtl_seq_no = request.getParameterValues("dtl_seq_no");
			String[] setle_mtd = request.getParameterValues("setle_mtd");
			String[] adju_amt = request.getParameterValues("adju_amt");
			String[] mbr_strte = request.getParameterValues("mbr_strte");
			String[] omp_sttl_amt = request.getParameterValues("omp_sttl_amt");
			String[] mbr_sttl_amt = request.getParameterValues("mbr_sttl_amt");
			menuDAO.deleteDtlAction(menu);
			for (int i = 0; i < setle_mtd.length; i++) {
				if ("".equals(adju_amt[i])) {
					adju_amt[i] = "0";
				}
				logger.debug("setle_mtd:" + setle_mtd[i]);
				// if(dtl_seq_no[i].equals("")){
				menuDAO.insertDtlAction(menu);
				// }else{
				// menu.setCrud_flag("update");
				// menuDAO.updateDtlAction(menu);
				// }
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 삭제:detail->master 순
	 * 
	 * @param seq_no
	 * @return @
	 */
	@Transactional
	public int deleteAction(MenuVO menu) {
		if (menuDAO.deleteDtlAction(menu) > 0) {
			return menuDAO.deleteAction(menu);
		} else {
			return 0;
		}
	}

	public MenuVO viewDtlSum(MenuVO adjust) {
		return menuDAO.viewDtlSum(adjust);
	}

}