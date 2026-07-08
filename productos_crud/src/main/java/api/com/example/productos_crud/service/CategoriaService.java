package api.com.example.productos_crud.service;

import api.com.example.productos_crud.entity.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listarTodas();
    Categoria buscarPorId(Long id);
    Categoria guardar(Categoria categoria);
    void eliminar(Long id);
}
