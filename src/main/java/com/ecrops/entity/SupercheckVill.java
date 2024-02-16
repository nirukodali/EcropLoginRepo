package com.ecrops.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SupercheckVill {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private String wbvname;
	private Long hod_allotted;
	private Long hod_approved;
	private Long hod_rejected;
	private Long dao_allotted;
	private Long dao_approved;
	private Long dao_rejected;
	private Long ada_allotted;
	private Long ada_approved;
	private Long ada_rejected;
	private Long mao_allotted;
	private Long mao_approved;
	private Long mao_rejected;
	private Long dho_allotted;
	private Long dho_approved;
	private Long dho_rejected;
	private Long ho_allotted;
	private Long ho_approved;
	private Long ho_rejected;
	private Long rdo_allotted;
	private Long rdo_approved;
	private Long rdo_rejected;
	private Long tah_allotted;
	private Long tah_approved;
	private Long tah_rejected;
	private Long dc_allotted;
	private Long dc_approved;
	private Long dc_rejected;
	private Long jc_allotted;
	private Long jc_approved;
	private Long jc_rejected;
	private String cr_dist_code;
	private String cr_mand_code;
	private Integer mcode;
	private String dname;
	private String mname;
	public SupercheckVill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupercheckVill(String wbvname, Long hod_allotted, Long hod_approved, Long hod_rejected, Long dao_allotted,
			Long dao_approved, Long dao_rejected, Long ada_allotted, Long ada_approved, Long ada_rejected,
			Long mao_allotted, Long mao_approved, Long mao_rejected, Long dho_allotted, Long dho_approved,
			Long dho_rejected, Long ho_allotted, Long ho_approved, Long ho_rejected, Long rdo_allotted,
			Long rdo_approved, Long rdo_rejected, Long tah_allotted, Long tah_approved, Long tah_rejected,
			Long dc_allotted, Long dc_approved, Long dc_rejected, Long jc_allotted, Long jc_approved, Long jc_rejected,
			String cr_dist_code, String cr_mand_code, Integer mcode, String dname, String mname) {
		super();
		this.wbvname = wbvname;
		this.hod_allotted = hod_allotted;
		this.hod_approved = hod_approved;
		this.hod_rejected = hod_rejected;
		this.dao_allotted = dao_allotted;
		this.dao_approved = dao_approved;
		this.dao_rejected = dao_rejected;
		this.ada_allotted = ada_allotted;
		this.ada_approved = ada_approved;
		this.ada_rejected = ada_rejected;
		this.mao_allotted = mao_allotted;
		this.mao_approved = mao_approved;
		this.mao_rejected = mao_rejected;
		this.dho_allotted = dho_allotted;
		this.dho_approved = dho_approved;
		this.dho_rejected = dho_rejected;
		this.ho_allotted = ho_allotted;
		this.ho_approved = ho_approved;
		this.ho_rejected = ho_rejected;
		this.rdo_allotted = rdo_allotted;
		this.rdo_approved = rdo_approved;
		this.rdo_rejected = rdo_rejected;
		this.tah_allotted = tah_allotted;
		this.tah_approved = tah_approved;
		this.tah_rejected = tah_rejected;
		this.dc_allotted = dc_allotted;
		this.dc_approved = dc_approved;
		this.dc_rejected = dc_rejected;
		this.jc_allotted = jc_allotted;
		this.jc_approved = jc_approved;
		this.jc_rejected = jc_rejected;
		this.cr_dist_code = cr_dist_code;
		this.cr_mand_code = cr_mand_code;
		this.mcode = mcode;
		this.dname = dname;
		this.mname = mname;
	}
	public String getWbvname() {
		return wbvname;
	}
	public void setWbvname(String wbvname) {
		this.wbvname = wbvname;
	}
	public Long getHod_allotted() {
		return hod_allotted;
	}
	public void setHod_allotted(Long hod_allotted) {
		this.hod_allotted = hod_allotted;
	}
	public Long getHod_approved() {
		return hod_approved;
	}
	public void setHod_approved(Long hod_approved) {
		this.hod_approved = hod_approved;
	}
	public Long getHod_rejected() {
		return hod_rejected;
	}
	public void setHod_rejected(Long hod_rejected) {
		this.hod_rejected = hod_rejected;
	}
	public Long getDao_allotted() {
		return dao_allotted;
	}
	public void setDao_allotted(Long dao_allotted) {
		this.dao_allotted = dao_allotted;
	}
	public Long getDao_approved() {
		return dao_approved;
	}
	public void setDao_approved(Long dao_approved) {
		this.dao_approved = dao_approved;
	}
	public Long getDao_rejected() {
		return dao_rejected;
	}
	public void setDao_rejected(Long dao_rejected) {
		this.dao_rejected = dao_rejected;
	}
	public Long getAda_allotted() {
		return ada_allotted;
	}
	public void setAda_allotted(Long ada_allotted) {
		this.ada_allotted = ada_allotted;
	}
	public Long getAda_approved() {
		return ada_approved;
	}
	public void setAda_approved(Long ada_approved) {
		this.ada_approved = ada_approved;
	}
	public Long getAda_rejected() {
		return ada_rejected;
	}
	public void setAda_rejected(Long ada_rejected) {
		this.ada_rejected = ada_rejected;
	}
	public Long getMao_allotted() {
		return mao_allotted;
	}
	public void setMao_allotted(Long mao_allotted) {
		this.mao_allotted = mao_allotted;
	}
	public Long getMao_approved() {
		return mao_approved;
	}
	public void setMao_approved(Long mao_approved) {
		this.mao_approved = mao_approved;
	}
	public Long getMao_rejected() {
		return mao_rejected;
	}
	public void setMao_rejected(Long mao_rejected) {
		this.mao_rejected = mao_rejected;
	}
	public Long getDho_allotted() {
		return dho_allotted;
	}
	public void setDho_allotted(Long dho_allotted) {
		this.dho_allotted = dho_allotted;
	}
	public Long getDho_approved() {
		return dho_approved;
	}
	public void setDho_approved(Long dho_approved) {
		this.dho_approved = dho_approved;
	}
	public Long getDho_rejected() {
		return dho_rejected;
	}
	public void setDho_rejected(Long dho_rejected) {
		this.dho_rejected = dho_rejected;
	}
	public Long getHo_allotted() {
		return ho_allotted;
	}
	public void setHo_allotted(Long ho_allotted) {
		this.ho_allotted = ho_allotted;
	}
	public Long getHo_approved() {
		return ho_approved;
	}
	public void setHo_approved(Long ho_approved) {
		this.ho_approved = ho_approved;
	}
	public Long getHo_rejected() {
		return ho_rejected;
	}
	public void setHo_rejected(Long ho_rejected) {
		this.ho_rejected = ho_rejected;
	}
	public Long getRdo_allotted() {
		return rdo_allotted;
	}
	public void setRdo_allotted(Long rdo_allotted) {
		this.rdo_allotted = rdo_allotted;
	}
	public Long getRdo_approved() {
		return rdo_approved;
	}
	public void setRdo_approved(Long rdo_approved) {
		this.rdo_approved = rdo_approved;
	}
	public Long getRdo_rejected() {
		return rdo_rejected;
	}
	public void setRdo_rejected(Long rdo_rejected) {
		this.rdo_rejected = rdo_rejected;
	}
	public Long getTah_allotted() {
		return tah_allotted;
	}
	public void setTah_allotted(Long tah_allotted) {
		this.tah_allotted = tah_allotted;
	}
	public Long getTah_approved() {
		return tah_approved;
	}
	public void setTah_approved(Long tah_approved) {
		this.tah_approved = tah_approved;
	}
	public Long getTah_rejected() {
		return tah_rejected;
	}
	public void setTah_rejected(Long tah_rejected) {
		this.tah_rejected = tah_rejected;
	}
	public Long getDc_allotted() {
		return dc_allotted;
	}
	public void setDc_allotted(Long dc_allotted) {
		this.dc_allotted = dc_allotted;
	}
	public Long getDc_approved() {
		return dc_approved;
	}
	public void setDc_approved(Long dc_approved) {
		this.dc_approved = dc_approved;
	}
	public Long getDc_rejected() {
		return dc_rejected;
	}
	public void setDc_rejected(Long dc_rejected) {
		this.dc_rejected = dc_rejected;
	}
	public Long getJc_allotted() {
		return jc_allotted;
	}
	public void setJc_allotted(Long jc_allotted) {
		this.jc_allotted = jc_allotted;
	}
	public Long getJc_approved() {
		return jc_approved;
	}
	public void setJc_approved(Long jc_approved) {
		this.jc_approved = jc_approved;
	}
	public Long getJc_rejected() {
		return jc_rejected;
	}
	public void setJc_rejected(Long jc_rejected) {
		this.jc_rejected = jc_rejected;
	}
	public String getCr_dist_code() {
		return cr_dist_code;
	}
	public void setCr_dist_code(String cr_dist_code) {
		this.cr_dist_code = cr_dist_code;
	}
	public String getCr_mand_code() {
		return cr_mand_code;
	}
	public void setCr_mand_code(String cr_mand_code) {
		this.cr_mand_code = cr_mand_code;
	}
	public Integer getMcode() {
		return mcode;
	}
	public void setMcode(Integer mcode) {
		this.mcode = mcode;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "SupercheckVill [wbvname=" + wbvname + ", hod_allotted=" + hod_allotted + ", hod_approved="
				+ hod_approved + ", hod_rejected=" + hod_rejected + ", dao_allotted=" + dao_allotted + ", dao_approved="
				+ dao_approved + ", dao_rejected=" + dao_rejected + ", ada_allotted=" + ada_allotted + ", ada_approved="
				+ ada_approved + ", ada_rejected=" + ada_rejected + ", mao_allotted=" + mao_allotted + ", mao_approved="
				+ mao_approved + ", mao_rejected=" + mao_rejected + ", dho_allotted=" + dho_allotted + ", dho_approved="
				+ dho_approved + ", dho_rejected=" + dho_rejected + ", ho_allotted=" + ho_allotted + ", ho_approved="
				+ ho_approved + ", ho_rejected=" + ho_rejected + ", rdo_allotted=" + rdo_allotted + ", rdo_approved="
				+ rdo_approved + ", rdo_rejected=" + rdo_rejected + ", tah_allotted=" + tah_allotted + ", tah_approved="
				+ tah_approved + ", tah_rejected=" + tah_rejected + ", dc_allotted=" + dc_allotted + ", dc_approved="
				+ dc_approved + ", dc_rejected=" + dc_rejected + ", jc_allotted=" + jc_allotted + ", jc_approved="
				+ jc_approved + ", jc_rejected=" + jc_rejected + ", cr_dist_code=" + cr_dist_code + ", cr_mand_code="
				+ cr_mand_code + ", mcode=" + mcode + ", dname=" + dname + ", mname=" + mname + "]";
	}
	

}
