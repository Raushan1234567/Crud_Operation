package com.masai;

import jakarta.persistence.*;

@Entity
//@NamedQueries({
//	@NamedQuery(name="FindByname", query="select e from Subscription e where e.name like :name")
//})
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String plan_name;
	private int  number_of_channels ;
	private double 	monthly_charges ;
	
	private String std1 ;
	private String end;
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subscription(String plan_name, int number_of_channels, double monthly_charges, String std1, String end) {
		super();
		this.plan_name = plan_name;
		this.number_of_channels = number_of_channels;
		this.monthly_charges = monthly_charges;
		this.std1 = std1;
		this.end = end;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public int getNumber_of_channels() {
		return number_of_channels;
	}
	public void setNumber_of_channels(int number_of_channels) {
		this.number_of_channels = number_of_channels;
	}
	public double getMonthly_charges() {
		return monthly_charges;
	}
	public void setMonthly_charges(double monthly_charges) {
		this.monthly_charges = monthly_charges;
	}
	public String getStd1() {
		return std1;
	}
	public void setStd1(String std1) {
		this.std1 = std1;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", plan_name=" + plan_name + ", number_of_channels=" + number_of_channels
				+ ", monthly_charges=" + monthly_charges + ", std1=" + std1 + ", end=" + end + "]";
	}
	
	
	
	
}
