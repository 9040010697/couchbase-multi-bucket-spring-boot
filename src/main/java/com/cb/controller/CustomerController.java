package com.cb.controller;

import com.cb.model.Customer;
import com.cb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerRepository repository;

  @GetMapping("/searchByPhoneNumber")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Customer> findByPhoneNumber(@RequestParam(name = "phoneNumber") String phoneNumber) {
    return repository.findByPhoneNumber(phoneNumber);
  }

  @GetMapping("/searchByMclCardNo")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Customer> findByMlcCardNo(@RequestParam(name = "mlcCardNo") String mlcCardNo) {
    return repository.findByMlcCardNo(mlcCardNo);
  }
}
