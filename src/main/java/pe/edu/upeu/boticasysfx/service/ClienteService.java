package pe.edu.upeu.boticasysfx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.boticasysfx.dto.ComboBoxOption;
import pe.edu.upeu.boticasysfx.model.Cliente;
import pe.edu.upeu.boticasysfx.repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repo;

    //C
    public Cliente save(Cliente to){
        return repo.save(to);
    }

    //R
    public List<Cliente> list(){
        return repo.findAll();
    }
    //U
    public Cliente update(Cliente to, String dniruc){
        try {
            Cliente toe=repo.findById(dniruc).orElse(null);
            if(toe!=null){
                toe.setNombres(to.getNombres());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }

    public Cliente update(Cliente to){
        return repo.save(to);
    }

    //D
    public void delete(String dniruc){
        repo.deleteById(dniruc);
    }
    //B
    public Cliente searchById(String dniruc){
        return repo.findById(dniruc).orElse(null);
    }


    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(Cliente cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getDniruc()));
            cb.setValue(cate.getNombres());
            listar.add(cb);
        }
        return listar;
    }
}
