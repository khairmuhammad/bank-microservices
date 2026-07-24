package com.khair.loans.service;

import com.khair.loans.dto.LoanDto;

public interface ILoansService {

    void createLoan(String mobileNumber);

    LoanDto fetchLoanDetails(String mobileNumber);

    boolean updateLoanDetails(LoanDto loanDto);

    boolean deleteLoan(String mobileNumber);
}
