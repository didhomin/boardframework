package com.kitri.board.model;

public class BbsDto extends BoardDto{
	private int bseq;
	private String orignFile;
	private String saveFile;
	private String savaFolder;
	private long fileSize;

	public int getBseq() {
		return bseq;
	}

	public void setBseq(int bseq) {
		this.bseq = bseq;
	}

	public String getOrignFile() {
		return orignFile;
	}

	public void setOrignFile(String orignFile) {
		this.orignFile = orignFile;
	}

	public String getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

	public String getSavaFolder() {
		return savaFolder;
	}

	public void setSavaFolder(String savaFolder) {
		this.savaFolder = savaFolder;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

}
