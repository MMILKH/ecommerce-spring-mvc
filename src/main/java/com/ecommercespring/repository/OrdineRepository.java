package com.ecommercespring.repository;

import com.ecommercespring.model.Carrello;
import com.ecommercespring.model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepository  extends JpaRepository<Ordine, Integer> {


}
