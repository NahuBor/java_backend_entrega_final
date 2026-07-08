package api.com.example.productos_crud.service;
import api.com.example.productos_crud.service.ProductoService;
import api.com.example.productos_crud.entity.Categoria;
import api.com.example.productos_crud.entity.Producto;
import api.com.example.productos_crud.repository.ProductoRepository;
import api.com.example.productos_crud.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional(readOnly = true) 
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));
    }

    @Override
@Transactional
public Producto guardar(Producto producto) {

    Categoria categoria = categoriaRepository.findById(producto.getCategoria().getId())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

    producto.setCategoria(categoria);

    return productoRepository.save(producto);
}

    @Override
    @Transactional
    public Producto actualizar(Long id, Producto productoDetalles) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede actualizar. Producto no encontrado con ID: " + id));

        productoExistente.setNombre(productoDetalles.getNombre());
        productoExistente.setPrecio(productoDetalles.getPrecio());
        productoExistente.setStock(productoDetalles.getStock());
        Categoria categoria = categoriaRepository.findById(productoDetalles.getCategoria().getId())
        .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        productoExistente.setCategoria(categoria);

        return productoRepository.save(productoExistente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede eliminar. Producto no encontrado con ID: " + id));
        
        productoRepository.delete(producto);
    }
}

