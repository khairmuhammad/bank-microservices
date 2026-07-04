package com.khair.accounts.service.impl;

import com.khair.accounts.constants.AccountsConstants;
import com.khair.accounts.dto.CustomerDto;
import com.khair.accounts.entity.Accounts;
import com.khair.accounts.entity.Customer;
import com.khair.accounts.exception.CustomerAlreadyExistsException;
import com.khair.accounts.mapper.CustomerMapper;
import com.khair.accounts.repository.AccountsRepository;
import com.khair.accounts.repository.CustomerRepository;
import com.khair.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with this mobile number: " + customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("System");
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setUpdatedBy("System");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("System");
        newAccount.setUpdatedAt(LocalDateTime.now());
        newAccount.setUpdatedBy("System");
        return newAccount;
    }
}
