package com.alvaro.demo.repository;

import com.alvaro.demo.entity.OrdenProducto;
import com.alvaro.demo.entity.OrdenProductoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenProductoRepository extends JpaRepository<OrdenProducto, OrdenProductoId> {
}
