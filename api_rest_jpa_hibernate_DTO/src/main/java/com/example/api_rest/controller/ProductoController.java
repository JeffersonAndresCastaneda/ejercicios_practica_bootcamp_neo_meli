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
import static com.example.api_rest.mapper.ProductoMapper.*;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @GetMapping
    public List<ProductoResponseDTO> listarTodos(){
        List<Producto> productos = productoService.listarTodos();
        return toResponseList(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable Long id) {
        Producto producto = productoService.buscarPorId(id);
        return ResponseEntity.ok(toResponse(producto));
    }

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crearProducto(@Valid @RequestBody ProductoRequestDTO dto) {
        Producto nuevo = productoService.crearProducto(toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(nuevo));
    }




    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizarProducto(@PathVariable Long id, @Valid @RequestBody ProductoRequestDTO dto) {
        Producto actualizado = productoService.actualizarProducto(id, toEntity(dto));
        return ResponseEntity.ok(toResponse(actualizado));
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.borrarProducto(id);
        return ResponseEntity.noContent().build();
    }



}




