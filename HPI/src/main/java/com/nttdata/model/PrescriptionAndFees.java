package com.nttdata.model;

import lombok.Data;

@Data
public class PrescriptionAndFees {
	
	public Long id;
	public String prescription;
	public double charges;
	public String note;

}
