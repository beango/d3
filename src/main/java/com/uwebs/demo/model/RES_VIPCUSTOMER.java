package com.uwebs.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "res_vipcustomer")
public class RES_VIPCUSTOMER implements java.io.Serializable {
	private static final long serialVersionUID = -4376187124011546736L;

	private Integer pkid;
	private String resId;
	private String mobile;
	//private Integer scheduleStatus;
	private String reason;
	private Date ctime;

	@Override
	public String toString() {
		return "PersonEntity [resiId=" + resId + ", mobile=" + mobile + "]";
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resiId) {
		this.resId = resiId;
	}

	@Column(length = 50, nullable = false, unique = true)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Id
	public Integer getPkid() {
		return pkid;
	}

	public void setPkid(Integer pkid) {
		this.pkid = pkid;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	/*public Integer getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(Integer schduleStatus) {
		this.scheduleStatus = schduleStatus;
	}*/

}