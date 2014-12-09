package com.goodbyenote.bapdosaptlweb.common.model;

public class MenuVO {

	private int depth;
	private int menuId;
	private int parentMenuId;
	private String menuName;
	private String menuTypeCmCode;
	private String menuTypeName;
	private String targetUrl;
	private int boardId;
	private String boardName;
	private String subject;
	private String isUsed;
	private int dispOrder;
	
	
	public int getDispOrder() {
		return dispOrder;
	}
	public void setDispOrder(int dispOrder) {
		this.dispOrder = dispOrder;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuTypeCmCode() {
		return menuTypeCmCode;
	}
	public void setMenuTypeCmCode(String menuTypeCmCode) {
		this.menuTypeCmCode = menuTypeCmCode;
	}
	public String getMenuTypeName() {
		return menuTypeName;
	}
	public void setMenuTypeName(String menuTypeName) {
		this.menuTypeName = menuTypeName;
	}
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	
}
