package com.sih.model;

import java.io.Serializable;
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
@Table(name="loan_schemes")
public class LoanScheme implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="loan_scheme_id")
	private Integer loanSchemeId;
	
	@Column(name="scheme_name")
	private String schemeName;
	
	@Column(name="guidelines")
	private String guidelines;
	
	@Column(name="eligibility_criteria")
	private String eligibilityCriteria;
	
	@Column(name="collateral")
	private int collateral;
	
	@Column(name="required_documents")
	private String requiredDocuments;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade={CascadeType.PERSIST,CascadeType.MERGE,
					CascadeType.DETACH,CascadeType.REFRESH}
			)
	@JoinTable(
			name="loan_schemes_bank",
			joinColumns=@JoinColumn(name="loan_scheme_id"),
			inverseJoinColumns=@JoinColumn(name="bank_id")
			)
	private List<Bank> banks;
	
	public LoanScheme(){
		
	}
	
	public Integer getLoanSchemeId() {
		return loanSchemeId;
	}
	public void setLoanSchemeId(Integer loanSchemeId) {
		this.loanSchemeId = loanSchemeId;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getGuidelines() {
		return guidelines;
	}
	public void setGuidelines(String guidelines) {
		this.guidelines = guidelines;
	}
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}
	public int getCollateral() {
		return collateral;
	}
	public void setCollateral(int collateral) {
		this.collateral = collateral;
	}
	public String getRequiredDocuments() {
		return requiredDocuments;
	}
	public void setRequiredDocuments(String requiredDocuments) {
		this.requiredDocuments = requiredDocuments;
	}
	public List<Bank> getBanks() {
		return banks;
	}
	public void setBanks(List<Bank> bank) {
		this.banks = bank;
	}
	
	public void addBanks(Bank bank){
		if(this.banks == null){
			this.banks = new ArrayList<>();
		}
		this.banks.add(bank);
	}

	@Override
	public String toString() {
		return "LoanSchemes [loanSchemeId=" + loanSchemeId + ", schemeName=" + schemeName + ", guidelines=" + guidelines
				+ ", eligibilityCriteria=" + eligibilityCriteria + ", collateral=" + collateral + ", requiredDocuments="
				+ requiredDocuments + "]";
	}
	
}
