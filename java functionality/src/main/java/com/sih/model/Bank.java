package com.sih.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="banks")
public class Bank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bank_id")
	private Integer bankId;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade={CascadeType.PERSIST,CascadeType.MERGE,
					CascadeType.DETACH,CascadeType.REFRESH}
			)
	@JoinTable(
			name="loan_schemes_bank",
			joinColumns=@JoinColumn(name="bank_id"),
			inverseJoinColumns=@JoinColumn(name="loan_scheme_id")
			)
	private List<LoanScheme> loanSchemes;
	
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public List<LoanScheme> getLoanSchemes() {
		return loanSchemes;
	}
	public void setLoanSchemes(List<LoanScheme> loanScheme) {
		this.loanSchemes = loanScheme;
	}
	
	public void addLoanSchemes(LoanScheme loanScheme){
		if(this.loanSchemes == null){
			this.loanSchemes = new ArrayList<>();
		}
		this.loanSchemes.add(loanScheme);
	}
	
	@Override
	public String toString() {
		return "Banks [bankId=" + bankId + ", bankName=" + bankName + ", contactNo=" + contactNo + "]";
	}

}
