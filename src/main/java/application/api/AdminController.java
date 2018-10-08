package application.api;

import application.dto.AdministratorDTO;
import application.entity.Administrator;
import application.helper.JSONResult;
import application.helper.JSONResultError;
import application.helper.JSONResultOk;
import application.service.helper.HashHelper;
import application.service.implementations.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/admins", produces = "application/json")
public class AdminController {

    @Autowired
    AdministratorService administratorService;

    @GetMapping("/{id}")
    public JSONResult<Administrator> getAdminById(@PathVariable("id") int id) {
        Administrator admin = new Administrator();
        try {
            admin = administratorService.getById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(admin, ex.getMessage());
        }
        return new JSONResultOk<>(admin);
    }

    @GetMapping
    public JSONResult<List<Administrator>> getAll() {
        List<Administrator> admins = new ArrayList<>();
        try {
            admins = administratorService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(admins, ex.getMessage());
        }
        return new JSONResultOk<>(admins);
    }

    @PutMapping("/{id}")
    public JSONResult<Administrator> updateAdministator(@RequestBody Administrator admin, @PathVariable("id") int id) {
        Administrator currentAdmin = new Administrator();
        try {
            currentAdmin = administratorService.getById(id);
            if (currentAdmin == null) {
                return new JSONResultError<>(currentAdmin, "entity no find!");
            }
            currentAdmin.setLogin(admin.getLogin());
            currentAdmin.setAdminHash(HashHelper.getHash(admin.getAdminHash()));
            administratorService.save(currentAdmin);
            currentAdmin.setAdminHash("hidden");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(currentAdmin, ex.getMessage());
        }
        return new JSONResultOk<>(currentAdmin);
    }

    @PostMapping
    public JSONResult<Administrator> addAdministrator(@RequestBody AdministratorDTO admin) {
        Administrator administrator = new Administrator();
        try {
            administrator.setLogin(admin.getLogin());
            administrator.setAdminHash(HashHelper.getHash(admin.getPassword()));
            administrator = administratorService.save(administrator);
            administrator.setAdminHash("hidden");
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(administrator, ex.getMessage());
        }
        return new JSONResultOk<>(administrator);
    }

    @DeleteMapping("/{id}")
    public JSONResult<Administrator> deleteAdministrator(@PathVariable int id) {
        Administrator admin = new Administrator();
        try {
            admin = administratorService.getById(id);
            administratorService.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new JSONResultError<>(admin, ex.getMessage());
        }
        return new JSONResultOk<>(admin);
    }
}
