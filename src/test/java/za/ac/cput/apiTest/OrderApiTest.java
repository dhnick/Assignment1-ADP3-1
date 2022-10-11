package za.ac.cput.apiTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.api.OrderApi;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.service.impl.OrderServiceImpl;


class OrderApiTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderApi api;

    private Order order = OrderFactory.createOrder("01Wed",
            "Wednesday Special",
            "Medium",
            8);


    @Test
    void save() {
        Order saved = this.api.save(this.order);
    }
}