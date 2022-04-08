package com.santander.banco811.controller;
import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.dto.AccountResponse;
import com.santander.banco811.model.Account;
import com.santander.banco811.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;
@RestController
@RequestMapping("/conta")
public class AccountController {
        @Autowired
        AccountService accountService;

        @GetMapping
        public List<Account> getAll(@RequestParam(required = false) Integer name) {
            return accountService.getAll(name);
        }

        @PostMapping
        public AccountResponse create(@RequestBody AccountRequest accountRequest) {
            var username = RequestContextHolder.getRequestAttributes().getAttribute(USERNAME, RequestAttributes.SCOPE_REQUEST).toString();
            return accountService.create(accountRequest, username);
        }

        @GetMapping("/{id}")
        public Account getById(@PathVariable Integer id) {
            return accountService.getById(id);
        }
  private static final String USERNAME = "USERNAME";

        @PutMapping("/{id}")
        public Account update(@PathVariable Integer id, @RequestBody AccountRequest accountRequest) {
            return accountService.update(accountRequest, id);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Integer id) {
            accountService.delete(id);
        }
    }

