package udea.edu.co.sistemagestion.gestion.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.edu.co.sistemagestion.gestion.Entidades.Enterprise;
import udea.edu.co.sistemagestion.gestion.Repositorio.RepositoryEnterprise;
import java.util.Optional;
import java.util.List;


@Service
public class ServicesEnterprise {

    List<Enterprise> enterprises;
    @Autowired
    RepositoryEnterprise repositoryEnterprise;

    public ServicesEnterprise(RepositoryEnterprise repositoryEnterprise){
        this.repositoryEnterprise = repositoryEnterprise;
    }

    //GET
    public List<Enterprise> enterprises(){
        return repositoryEnterprise.findAll();
    }

    //GETBYID
    public Optional<Enterprise> findEnterprise(Long id){
        return repositoryEnterprise.findById(id);
    }

    //POST
    public Enterprise saveEnterprise(Enterprise enterprise){
        return repositoryEnterprise.save(enterprise);
    }

    //PATCH
    public Enterprise updateEnterprise(Long id, Enterprise enterprise){
        Enterprise auxEnterprise = repositoryEnterprise.findById(id).orElse(null);
        auxEnterprise.setId(enterprise.getId());
        auxEnterprise.setName(enterprise.getName());
        auxEnterprise.setDocument(enterprise.getDocument());
        auxEnterprise.setPhone(enterprise.getPhone());
        auxEnterprise.setAddress(enterprise.getAddress());
        auxEnterprise.setUser(enterprise.getUser());
        auxEnterprise.setTransactions(enterprise.getTransactions());
        auxEnterprise.setCreatedAt(enterprise.getCreatedAt());
        auxEnterprise.setUpdatedAt(enterprise.getUpdatedAt());
        repositoryEnterprise.save(auxEnterprise);
        return auxEnterprise;
    }

    //DELETE
    public void deleteEnterprise(Enterprise enterprise){
        repositoryEnterprise.delete(enterprise);
    }


    }
