package pe.edu.upeu.boticasysfx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.boticasysfx.dto.ComboBoxOption;
import pe.edu.upeu.boticasysfx.model.Categoria;
import pe.edu.upeu.boticasysfx.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    //C
    public Categoria save(Categoria to){
        return repo.save(to);
    }

    //R
    public List<Categoria> list(){
        return repo.findAll();
    }
    //U
    public Categoria update(Categoria to, Long id){
        try {
            Categoria toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }

    public Categoria update(Categoria to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public Categoria searchById(Long id){
        return repo.findById(id).orElse(null);
    }


    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(Categoria cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCategoria()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }

}
