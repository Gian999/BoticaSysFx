package pe.edu.upeu.boticasysfx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.boticasysfx.dto.ComboBoxOption;
import pe.edu.upeu.boticasysfx.model.Medicamento;
import pe.edu.upeu.boticasysfx.repository.MedicamentoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicamentoService {
    @Autowired
    MedicamentoRepository repo;

    public Medicamento save(Medicamento to){
        return repo.save(to);
    }
    public List<Medicamento> list(){
        return repo.findAll();
    }
    public Medicamento update(Medicamento to, Long id){
        try {
            Medicamento toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }

    public Medicamento update(Medicamento to){
        return repo.save(to);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public Medicamento searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(Medicamento cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdMedicamento()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }
}
