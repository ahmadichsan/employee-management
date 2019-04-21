package com.app.employeemanagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "employee_feedback")
public class EmployeeFeedback {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewee_id")
	private Employee employeeReviewee;
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewer_id")
	private Employee employeeReviewer;
	
    @Column(name = "start_date_of_week", nullable = false)
	private Date startDateOfTheWeek;
	
    @Column(name = "end_date_of_week", nullable = false)
	private Date endDateOfTheWeek;
	
    @Column(name = "rate", nullable = false)
	private int rate;
	
    @Column(name = "feedback", nullable = true)
	private String feedback;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
    
    @UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
    private Date updatedAt;
    
    public EmployeeFeedback() {
    	
    }

	public EmployeeFeedback(Long id, Employee employeeReviewee, Employee employeeReviewer, Date startDateOfTheWeek, Date endDateOfTheWeek, int rate, String feedback, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.employeeReviewee = employeeReviewee;
		this.employeeReviewer = employeeReviewer;
		this.startDateOfTheWeek = startDateOfTheWeek;
		this.endDateOfTheWeek = endDateOfTheWeek;
		this.rate = rate;
		this.feedback = feedback;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployeeReviewee() {
		return employeeReviewee;
	}

	public void setEmployeeReviewee(Employee employeeReviewee) {
		this.employeeReviewee = employeeReviewee;
	}

	public Employee getEmployeeReviewer() {
		return employeeReviewer;
	}

	public void setEmployeeReviewer(Employee employeeReviewer) {
		this.employeeReviewer = employeeReviewer;
	}

	public Date getStartDateOfTheWeek() {
		return startDateOfTheWeek;
	}

	public void setStartDateOfTheWeek(Date startDateOfTheWeek) {
		this.startDateOfTheWeek = startDateOfTheWeek;
	}

	public Date getEndDateOfTheWeek() {
		return endDateOfTheWeek;
	}

	public void setEndDateOfTheWeek(Date endDateOfTheWeek) {
		this.endDateOfTheWeek = endDateOfTheWeek;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
