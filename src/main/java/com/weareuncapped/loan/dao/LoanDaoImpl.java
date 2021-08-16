package com.weareuncapped.loan.dao;

import com.weareuncapped.loan.dto.LoanDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class LoanDaoImpl implements LoanDao {

    private static HashMap<Long, LoanDto> loans = new HashMap<>();
    private static Long currentId = 0L;

    public Optional<LoanDto> get(Long id) {
        return Optional.ofNullable(loans.get(id));
    }

    public Optional<LoanDto> update(Long id, LoanDto loanDto) {
        if (loans.containsKey(id)) {
            return Optional.ofNullable(loans.put(id, loanDto));
        }
        return Optional.empty();
    }

    public Long remove(Long id) {
        loans.remove(id);
        return id;
    }
    public Long add(LoanDto loanDto) {
        Long id = currentId++;
        loans.put(id, loanDto);
        return id;
    }
}
