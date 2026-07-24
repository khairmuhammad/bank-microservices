package com.khair.loans.service.impl;

import com.khair.loans.constants.LoansConstants;
import com.khair.loans.dto.LoanDto;
import com.khair.loans.entity.Loan;
import com.khair.loans.exception.LoanAlreadyExistsException;
import com.khair.loans.exception.ResourceNotFoundException;
import com.khair.loans.mapper.LoansMapper;
import com.khair.loans.repository.LoansRepository;
import com.khair.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loan> existingLoan = loansRepository.findByMobileNumber(mobileNumber);
        if (existingLoan.isPresent()) {
            throw new LoanAlreadyExistsException("Loan already exists for mobile number: " + mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    private Loan createNewLoan(String mobileNumber) {
        Loan newLoan = new Loan();
        newLoan.setMobileNumber(mobileNumber);
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoanDto fetchLoanDetails(String mobileNumber) {
        Loan loan = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found for mobile number: " + mobileNumber));
        return LoansMapper.mapToLoanDto(loan, new LoanDto());
    }

    @Override
    public boolean updateLoanDetails(LoanDto loanDto) {
        Loan loan = loansRepository.findByLoanNumber(loanDto.getLoanNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found for loan number: " + loanDto.getLoanNumber()));
        LoansMapper.mapToLoan(loanDto, loan);
        loansRepository.save(loan);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loan loan = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found for mobile number: " + mobileNumber));
        loansRepository.delete(loan);
        return true;
    }
}
