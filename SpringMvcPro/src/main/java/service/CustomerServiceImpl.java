package service;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    public String getInfos(String name) {

        return "getInfos" + name;
    }

    public String showInfos() {

        return "Show Infos";
    }
}
