package za.ac.cput.apiTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.api.CustomerApi;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;

@SpringBootTest
class CustomerApiTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerApi customerApi;

    public Customer customer = CustomerFactory.createCustomer("158796WE",
            "Wayne",
            "Ericson",
            "EricsonW21@gmail.com",
            "12 Sunrise Close Clipfontein",
            "087 456 7894");

    @Test
    void save(){
        Customer save = this.customerApi.save(this.customer);
    }



    /*  @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerApi api;

    private Customer customer = CustomerFactory.createCustomer("419845lP",
            "Logan",
            "Paul",
            "PaulL@gmail.com",
            "45 View Street BlueHill",
            "067 859 7453");

    @Test
    void save() {
        //Customer saved = this.api.save(this.customer);
    }
*/




}