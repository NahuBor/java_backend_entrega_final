package api.com.example.productos_crud.service;

import api.com.example.productos_crud.entity.Categoria;
import api.com.example.productos_crud.service.CategoriaService;
import api.com.example.productos_crud.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con el ID: " + id));
    }

    @Override
    @Transactional
    public Categoria guardar(Categoria categoria) {
        categoriaRepository.findByNombre(categoria.getNombre()).ifPresent(c -> {
            throw new RuntimeException("La categoría '" + categoria.getNombre() + "' ya existe.");
        });
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede eliminar. Categoría no encontrada con ID: " + id));
        
        categoriaRepository.delete(categoria);
    }
}
