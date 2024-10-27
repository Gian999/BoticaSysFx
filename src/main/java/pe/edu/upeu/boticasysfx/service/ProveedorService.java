package pe.edu.upeu.boticasysfx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.boticasysfx.model.Proveedor;
import pe.edu.upeu.boticasysfx.repository.ProveedorRepository;

import java.util.List;

@Service
public class ProveedorService {
    @Autowired
    ProveedorRepository repo;

    public Proveedor save(Proveedor to){
        return repo.save(to);
    }
    public List<Proveedor> list(){
        return repo.findAll();
    }
    public Proveedor update(Proveedor to, Long id){
        try {
            Proveedor toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }

    public Proveedor update(Proveedor to){
        return repo.save(to);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public Proveedor searchById(Long id){
        return repo.findById(id).get();
    }
}
