package com.weareuncapped.loan.services;


import com.weareuncapped.loan.dao.LoanDao;
import com.weareuncapped.loan.dto.LoanDto;
import com.weareuncapped.loan.exception.LoanException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LoanServiceImplTest {

    private static final LocalDateTime END_DATE = LocalDateTime.of(2000, 1, 1, 1, 1, 1, 1);
    private static final LocalDateTime START_DATE = LocalDateTime.of(1998, 1, 1, 1, 1, 1, 1);

    private static final BigDecimal LOAN = new BigDecimal(10);
    private static final Long LOAN_ID = 1L;
    private LoanDto loanDto;
    @Autowired
    LoanService loanService;
    LoanDao loanDao;

    @BeforeEach
    private void setUp() {
        loanDao = Mockito.mock(LoanDao.class);
        loanService = new LoanServiceImpl(loanDao);
        setUpLoanDto();
    }

    private void setUpLoanDto() {
        loanDto = new LoanDto();
        loanDto.setLoan(LOAN);
        loanDto.setFee(BigDecimal.ONE);
        loanDto.setStartDate(START_DATE);
        loanDto.setEndDate(END_DATE);
    }

    @Test
    public void addLoanShouldAddLoan() throws LoanException {
        when(loanDao.add(any())).thenReturn(LOAN_ID);
        loanService.add(loanDto);
    }

    @Test
    public void removeLoanShouldRemoveLoan() {
        loanService.remove(LOAN_ID);
    }

    @Test
    public void updateLoanShouldUpdateLoan() throws LoanException {
        when(loanDao.update(any(), any())).thenReturn(Optional.of(loanDto));
        loanService.update(LOAN_ID, loanDto);
    }

    @Test
    public void getLoan() throws LoanException {
        when(loanDao.get(any())).thenReturn(Optional.of(loanDto));
        loanService.get(LOAN_ID);
    }
}

