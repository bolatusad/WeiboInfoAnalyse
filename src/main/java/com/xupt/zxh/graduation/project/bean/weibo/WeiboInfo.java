package com.xupt.zxh.graduation.project.bean.weibo;

/**
 * 单个的微博 bean，用于临时存储采集的微博信息
 * @author 张涛
 *
 */
public class WeiboInfo {


	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 单条微博的id
	 */
	private String weiboId;
	
	/**
	 * 单条微博的内容
	 */
	private String weiboContent;
	
	/**
	 * 微博的发布时间
	 */
	private String time;
	
	/**
	 * 微博的发布者
	 */
	private String weiboAuthor;
	
	/**
	 * 微博的发布方式
	 */
	private String releaseWay;
	
	/**
	 * 是否为转发微博：1 表示为转发微博  0 表示不是转发微博
	 */
	private int isForward;
	
	/**
	 * 转发理由：若为转发微博，且转发理由不为空，则采集转发理由
	 */
	private String reasonOfForward;
	
	/**
	 * 微博的赞数
	 */
	private Integer praiseNum;
	
	/**
	 * 微博评论数
	 */
	private Integer commentNum;
	
	/**
	 * 微博转发数
	 */
	private Integer forwardNum;
	
	/**
	 * 是否有图：1 表示有图，2表示没有图
	 */
	private int hasPicture;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWeiboId() {
		return weiboId;
	}

	public void setWeiboId(String weiboId) {
		this.weiboId = weiboId;
	}

	public String getWeiboContent() {
		return weiboContent;
	}

	public void setWeiboContent(String weiboContent) {
		this.weiboContent = weiboContent;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeiboAuthor() {
		return weiboAuthor;
	}

	public void setWeiboAuthor(String weiboAuthor) {
		this.weiboAuthor = weiboAuthor;
	}

	public String getReleaseWay() {
		return releaseWay;
	}

	public void setReleaseWay(String releaseWay) {
		this.releaseWay = releaseWay;
	}

	public int getIsForward() {
		return isForward;
	}

	public void setIsForward(int isForward) {
		this.isForward = isForward;
	}

	public String getReasonOfForward() {
		return reasonOfForward;
	}

	public void setReasonOfForward(String reasonOfForward) {
		this.reasonOfForward = reasonOfForward;
	}

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getForwardNum() {
		return forwardNum;
	}

	public void setForwardNum(Integer forwardNum) {
		this.forwardNum = forwardNum;
	}

	public int getHasPicture() {
		return hasPicture;
	}

	public void setHasPicture(int hasPicture) {
		this.hasPicture = hasPicture;
	}

	@Override
	public String toString() {
		return "WeiboInfo [weiboId=" + weiboId + ", weiboContent="
				+ weiboContent + ", time=" + time + ", weiboAuthor="
				+ weiboAuthor + ", releaseWay=" + releaseWay + ", isForward="
				+ isForward + ", reasonOfForward=" + reasonOfForward
				+ ", praiseNum=" + praiseNum + ", commentNum=" + commentNum
				+ ", forwardNum=" + forwardNum + ", hasPicture=" + hasPicture
				+ "]";
	}
	
	
	

}
