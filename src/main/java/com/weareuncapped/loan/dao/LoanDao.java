package com.weareuncapped.loan.dao;

import com.weareuncapped.loan.dto.LoanDto;

import java.util.Optional;

public interface LoanDao {

    Optional<LoanDto> get(Long id);

    Optional<LoanDto> update(Long id, LoanDto loanDto);

    Long remove(Long id);

    Long add(LoanDto loanDto);
}
