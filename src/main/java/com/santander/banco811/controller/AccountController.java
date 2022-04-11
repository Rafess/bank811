package com.santander.banco811.controller;
import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.dto.AccountResponse;
import com.santander.banco811.model.Account;
import com.santander.banco811.model.AccountType;
import com.santander.banco811.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class AccountController {
        @Autowired
        AccountService accountService;

        @GetMapping
        public Page<Account> getAll(@RequestParam(required = false) Integer name,
                                    @RequestParam(required = false, defaultValue = "0") int page,
                                    @RequestParam(required = false, defaultValue = "3") int size) {
            return accountService.getAll(name, page, size);
        }

        @GetMapping("/tipoConta")
        public Page<AccountResponse> getAllByAccountType(@RequestParam AccountType accountType,
                                                         @RequestParam(required = false, defaultValue = "0") int page,
                                                         @RequestParam(required = false, defaultValue = "3") int size) {
            return  accountService.getAllByAccountType(accountType, page, size);
        }

        @PostMapping
        public AccountResponse create(@RequestBody AccountRequest accountRequest) {
            return accountService.create(accountRequest);
        }

        @GetMapping("/{id}")
        public Account getById(@PathVariable Integer id) {
            return accountService.getById(id);
        }

        @PutMapping("/{id}")
        public Account update(@PathVariable Integer id, @RequestBody AccountRequest accountRequest) {
            return accountService.update(accountRequest, id);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Integer id) {
            accountService.delete(id);
        }
    }

