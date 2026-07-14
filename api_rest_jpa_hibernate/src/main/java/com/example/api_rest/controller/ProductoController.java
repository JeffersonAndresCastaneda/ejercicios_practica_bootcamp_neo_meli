package com.example.api_rest.controller;

import com.example.api_rest.dto.ProductoRequestDTO;
import com.example.api_rest.dto.ProductoResponseDTO;
import com.example.api_rest.model.Producto;
import com.example.api_rest.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.api_rest.mapper.ProductoMapper.toEntity;
import static com.example.api_rest.mapper.ProductoMapper.toResponse;
import static com.example.api_rest.mapper.ProductoMapper.toResponseList;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoResponseDTO> listarTodos() {
        List<Producto> productos = productoService.listarTodos();
        return toResponseList(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id)
                .map(producto -> ResponseEntity.ok(toResponse(producto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crearProducto(@Valid @RequestBody ProductoRequestDTO dto) {
        Producto nuevo = productoService.crearProducto(toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizarProducto(@PathVariable Long id,
                                                                   @Valid @RequestBody ProductoRequestDTO dto) {
        return productoService.actualizarProducto(id, toEntity(dto))
                .map(producto -> ResponseEntity.ok(toResponse(producto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = productoService.borrarProducto(id);
        return eliminado
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
