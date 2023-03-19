package com.csi.dao;

import com.csi.model.Customer;
import com.csi.model.Department;
import com.csi.repo.CustomerRepo;
import com.csi.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class CustomerDaoImpl {

    @Autowired
    CustomerRepo customerRepoImpl;

    @Autowired
    DepartmentRepo departmentRepo;

    public Customer saveData(Customer customer) {
        Customer customer1 = new Customer();

        Department department = new Department();
        /*customer1.setCustId(customer.getCustId());
        customer1.setCustName(customer.getCustName());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustSalary(customer.getCustSalary());*/
        customer1 = customerRepoImpl.save(customer);
        customer1.setDepartment(departmentRepo.save(customer.getDepartment()));

        return customer1;
    }

    public List<Customer> getAllData() {
        return customerRepoImpl.findAll();
    }

    public Customer updateData(Customer customer) {
        return customerRepoImpl.save(customer);
    }

    public void deleteData(int custId) {
        customerRepoImpl.deleteById(custId);
    }
}

