package com.primerparcialpn.articulos;

import com.primerparcialpn.articulos.models.Categoria;
import com.primerparcialpn.articulos.repository.CategoriaRepository;
import com.primerparcialpn.articulos.services.CategoriaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class CategoriaServiceMockTest {
    public static Categoria mockCategoria() {
        Categoria modelo = new Categoria();
        modelo.setId(1L);
        modelo.setNombre("Limpiza");
        modelo.setDescripcion("Productos detergetes");

        return modelo;
    }

    @InjectMocks
    private CategoriaServiceImpl categoriaService;
    @Mock
    private CategoriaRepository categoriaRepository;


    @DisplayName("Test para listar a las categorias")
    @Test
    void gatAllCategoriaTest() {
        //Given
        Categoria categoria = mockCategoria();
        //When
        ResponseEntity<List<Categoria>> lista = categoriaService.allCategorias();
        //Then
        Assertions.assertNotNull(lista);
    }

}
