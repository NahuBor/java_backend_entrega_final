package api.com.example.productos_crud.service;
import java.util.List;
import api.com.example.productos_crud.entity.Producto;
import org.springframework.stereotype.Service;
@Service

public interface ProductoService {
    List<Producto> listarTodos();
    Producto buscarPorId(Long id);
    Producto guardar(Producto producto);
    Producto actualizar(Long id, Producto productoDetalles);
    void eliminar(Long id);
}
