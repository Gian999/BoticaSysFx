package pe.edu.upeu.boticasysfx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.boticasysfx.dto.ComboBoxOption;
import pe.edu.upeu.boticasysfx.model.Marca;
import pe.edu.upeu.boticasysfx.repository.MarcaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaService {
    @Autowired
    MarcaRepository repo;

    //C
    public Marca save(Marca to){
        return repo.save(to);
    }

    //R
    public List<Marca> list(){
        return repo.findAll();
    }
    //U
    public Marca update(Marca to, Long id){
        try {
            Marca toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }

    public Marca update(Marca to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public Marca searchById(Long id){
        return repo.findById(id).orElse(null);
    }


    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(Marca cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdMarca()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }
}
