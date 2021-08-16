package com.weareuncapped.loan.services;

import com.weareuncapped.loan.dao.LoanDao;
import com.weareuncapped.loan.dto.LoanDto;
import com.weareuncapped.loan.exception.LoanException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanDao loanDao;

    public LoanServiceImpl(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    @Override
    public Long add(LoanDto loanDto) throws LoanException {
        validateLoanUpsert(loanDto);
        return loanDao.add(loanDto);
    }

    @Override
    public Long remove(Long id) {
        return loanDao.remove(id);
    }

    @Override
    public LoanDto update(Long id, LoanDto loanDto) throws LoanException {
        validateLoanUpsert(loanDto);
        return loanDao.update(id, loanDto).orElseThrow(() -> new LoanException("Loan with provided id does not exist"));
    }

    @Override
    public LoanDto get(Long id) throws LoanException {
        return loanDao.get(id).orElseThrow(() -> new LoanException("Loan with provided id does not exist"));
    }

    private void validateLoanUpsert(LoanDto loanDto) throws LoanException {
        BigDecimal loan = loanDto.getLoan();
        BigDecimal fee = loanDto.getFee();
        if (Objects.isNull(loan)) {
           throw new LoanException("Loan value cannot be empty");
        }
        if (Objects.isNull(fee)) {
            throw new LoanException("Fee value cannot be empty");
        }
        if (Objects.isNull(loanDto.getStartDate())) {
            throw new LoanException("Start date value cannot be empty");
        }
        if (Objects.isNull(loanDto.getEndDate())) {
            throw new LoanException("End date value cannot be empty");
        }
        if (loanDto.getLoan().compareTo(BigDecimal.ZERO) < 0 ) {
            throw new LoanException("Loan cannot be negative");
        }
        if (loanDto.getFee().compareTo(BigDecimal.ZERO) < 0 ) {
            throw new LoanException("Fee cannot be negative");
        }
        if (loanDto.getLoan().compareTo(loanDto.getFee()) < 0) {
            throw new LoanException("Fee cannot be bigger than loan");
        }
        if (loanDto.getStartDate().isAfter(loanDto.getEndDate())) {
            throw new LoanException("End date cannot be older than start date");
        }
    }
}
