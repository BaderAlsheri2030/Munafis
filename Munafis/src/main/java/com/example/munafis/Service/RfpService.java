package com.example.munafis.Service;



import com.example.munafis.API.ApiException;
import com.example.munafis.DTO.RfpDTO;
import com.example.munafis.Model.Company;
import com.example.munafis.Model.Competition;
import com.example.munafis.Model.Rfp;
import com.example.munafis.Repository.CompanyRepository;
import com.example.munafis.Repository.CompetitionRepository;
import com.example.munafis.Repository.RfpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RfpService {
    private final RfpRepository rfpRepository;
    private final CompetitionRepository competitionRepository;
    private final CompanyRepository companyRepository;

    public List<Rfp> getAll(){
        return rfpRepository.findAll();
    }

    public void addRfp(RfpDTO rfpDTO,Integer company_id,Integer comp_id){
        Competition competition = competitionRepository.findCompetitionById(comp_id);
        Company company = companyRepository.findCompanyById(company_id);
        if (competition == null){
            throw new ApiException("there's no competition");
        }
        if (company == null){
            throw new ApiException("Invalid company");
        }
        Rfp rfp = new Rfp(null,rfpDTO.getDescription(),rfpDTO.getReference_number(),rfpDTO.getCompetition_type(),rfpDTO.getDead_line(),rfpDTO.getContract_length(),rfpDTO.getService_details(),rfpDTO.getTitle(),rfpDTO.isComplete(),rfpDTO.getTime_left(),company,competition);
        rfpRepository.save(rfp);
    }

    public void updateRfp(Integer rfp_id,RfpDTO rfpDTO,Integer company_id){
        Company company = companyRepository.findCompanyById(company_id);
        Rfp rfp = rfpRepository.findRfpById(rfp_id);
        if (company == null){
            throw new ApiException("Invalid company");
        }
        if (rfp == null){
            throw new ApiException("Invalid proposal");
        }
        rfp.setDescription(rfpDTO.getDescription());
        rfp.setCompetitionType(rfpDTO.getCompetition_type());
        rfp.setContractLength(rfpDTO.getContract_length());
        rfp.setDeadLine(rfpDTO.getDead_line());
        rfp.setServiceDetails(rfpDTO.getService_details());
        rfp.setTimeLeft(rfpDTO.getTime_left());
        rfp.setTitle(rfpDTO.getTitle());
        rfpRepository.save(rfp);
    }

    public void deleteRfp(Integer rfp_id){
        Rfp rfp = rfpRepository.findRfpById(rfp_id);
        if (rfp == null){
            throw new ApiException("invalid");
        }
        rfpRepository.delete(rfp);
    }

}
