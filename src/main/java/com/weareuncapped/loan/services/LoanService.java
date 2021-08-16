package com.weareuncapped.loan.services;

import com.weareuncapped.loan.dto.LoanDto;
import com.weareuncapped.loan.exception.LoanException;

public interface LoanService {

    Long add(LoanDto loanDto) throws LoanException;
    Long remove(Long id);
    LoanDto update(Long id, LoanDto loanDto) throws LoanException;
    LoanDto get(Long id) throws LoanException;
}
