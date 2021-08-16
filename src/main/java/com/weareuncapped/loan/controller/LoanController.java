package com.weareuncapped.loan.controller;

import com.weareuncapped.loan.dto.LoanDto;
import com.weareuncapped.loan.exception.LoanException;
import com.weareuncapped.loan.services.LoanServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController("/loans")
public class LoanController {

    private final LoanServiceImpl loanService;

    public LoanController(LoanServiceImpl loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public Long create(LoanDto loanDto) throws LoanException {
        return loanService.add(loanDto);
    }

    @GetMapping("/{id}")
    public LoanDto get(@PathParam("id") Long loanId) throws LoanException {
        return loanService.get(loanId);
    }

    @PutMapping("/{id}")
    public LoanDto update(@PathParam("id") Long id,
                          LoanDto loanDto) throws LoanException {
        return loanService.update(id, loanDto);
    }

    @DeleteMapping
    public Long remove(Long loanId) {
        return loanService.remove(loanId);
    }

}
