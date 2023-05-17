package com.pfm.project.dto;



public class DB_UPDateAPI_Request {
	private Long SH_ID;	//업소아이디
    private String SH_NAME;	//업소명
    private int INDUTY_CODE_SE;	//분류코드
    private String INDUTY_CODE_SE_NAME;	//분류코드명
	private String SH_ADDR;	//업소 주소
	private String SH_PHONE;	//업소 전화번호
	private String SH_WAY;	//찾아오시는 길
	private String SH_INFO;	//업소정보
	private String SH_PRIDE;	//자랑거리
	private String SH_PHOTO;	//업소 사진

	public DB_UPDateAPI_Request() {
	}
	public DB_UPDateAPI_Request(Long SH_ID, String SH_NAME, int INDUTY_CODE_SE, String INDUTY_CODE_SE_NAME,
								String SH_ADDR, String SH_PHONE, String SH_WAY, String SH_INFO, String SH_PRIDE, String SH_PHOTO) {
		this.SH_ID = SH_ID;
		this.SH_NAME = SH_NAME;
		this.INDUTY_CODE_SE = INDUTY_CODE_SE;
		this.INDUTY_CODE_SE_NAME = INDUTY_CODE_SE_NAME;
		this.SH_ADDR = SH_ADDR;
		this.SH_PHONE = SH_PHONE;
		this.SH_WAY = SH_WAY;
		this.SH_INFO = SH_INFO;
		this.SH_PRIDE = SH_PRIDE;
		this.SH_PHOTO = SH_PHOTO;
	}



	public Long getSH_ID() {
		return SH_ID;
	}

	public String getSH_NAME() {
		return SH_NAME;
	}

	public int getINDUTY_CODE_SE() {
		return INDUTY_CODE_SE;
	}

	public String getINDUTY_CODE_SE_NAME() {
		return INDUTY_CODE_SE_NAME;
	}

	public String getSH_ADDR() {
		return SH_ADDR;
	}

	public String getSH_PHONE() {
		return SH_PHONE;
	}

	public String getSH_WAY() {
		return SH_WAY;
	}

	public String getSH_INFO() {
		return SH_INFO;
	}

	public String getSH_PRIDE() {
		return SH_PRIDE;
	}

	public String getSH_PHOTO() {
		return SH_PHOTO;
	}
}
