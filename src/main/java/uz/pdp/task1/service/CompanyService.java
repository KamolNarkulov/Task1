package uz.pdp.task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.task1.entity.Address;
import uz.pdp.task1.entity.Company;
import uz.pdp.task1.payload.AddressDto;
import uz.pdp.task1.payload.ApiResponse;
import uz.pdp.task1.payload.CompanyDto;
import uz.pdp.task1.repository.AddressRepository;
import uz.pdp.task1.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    AddressRepository addressRepository;

    // CREATE
    public ApiResponse add(CompanyDto companyDto){
       if (addressRepository.existsByHomeNumberAndStreet(companyDto.getHomeNumber(), companyDto.getStreet()))
           return new ApiResponse("Bunday manzil kiritilgan", false);

        Company company = new Company();
        company.setCorpName(companyDto.getCorpName());
        company.setDirectorName(companyDto.getDirectorName());
        companyRepository.save(company);

        Address address = new Address();
        address.setStreet(companyDto.getStreet());
        address.setHomeNumber(companyDto.getHomeNumber());
        addressRepository.save(address);
        return new ApiResponse("Saved", true);
    }

    // READ
    public List<Company> get(){
        return companyRepository.findAll();
    }

    // READ BY ID
    public Company getById(Integer id){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        return optionalCompany.orElse(null);
    }

    // UPDATE
    public ApiResponse edit(Integer id, CompanyDto companyDto){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (!optionalCompany.isPresent())
            return new ApiResponse("Company not found", false);

        if (addressRepository.existsByHomeNumberAndStreetAndIdNot(companyDto.getHomeNumber(), companyDto.getStreet(), id))
            return new ApiResponse("Bunday manzil mavjud", false);


        Company company = optionalCompany.get();
        company.setCorpName(companyDto.getCorpName());
        company.setDirectorName(companyDto.getDirectorName());
        companyRepository.save(company);

        Optional<Address> optionalAddress = addressRepository.findById(companyDto.getAddressId());
        Address address = optionalAddress.get();
        address.setStreet(companyDto.getStreet());
        address.setHomeNumber(companyDto.getHomeNumber());
        return new ApiResponse("Edited", true);
    }

    // DELETE
    public ApiResponse delete(Integer id){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (!optionalCompany.isPresent())
            return new ApiResponse("Company not found", false);

        companyRepository.deleteById(id);
        return new ApiResponse("Deleted", true);
    }
}
