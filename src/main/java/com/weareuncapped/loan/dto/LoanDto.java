package com.weareuncapped.loan.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanDto {

    private BigDecimal loan;
    private BigDecimal fee;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public BigDecimal getLoan() {
        return loan;
    }

    public void setLoan(BigDecimal loan) {
        this.loan = loan;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

}
