package com.Model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileData {

	@Id
	private int fid;

	private String fname;

	private String fpath;

	@Lob
	private byte[] fdata;

	private long fsize;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

	public byte[] getFdata() {
		return fdata;
	}

	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}

	public long getFsize() {
		return fsize;
	}

	public void setFsize(long fsize) {
		this.fsize = fsize;
	}

	@Override
	public String toString() {
		return "FileData [fid=" + fid + ", fname=" + fname + ", fpath=" + fpath + ", fdata=" + Arrays.toString(fdata)
				+ ", fsize=" + fsize + "]";
	}
	

}
