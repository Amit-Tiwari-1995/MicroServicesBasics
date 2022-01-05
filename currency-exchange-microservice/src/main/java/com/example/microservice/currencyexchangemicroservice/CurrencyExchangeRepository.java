package com.example.microservice.currencyexchangemicroservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);

    List<CurrencyExchange> findAll();


}
