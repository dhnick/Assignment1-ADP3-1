/* OrderFactory.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.Factory;

import za.ac.cput.Domain.Order;
import za.ac.cput.util.GenericHelper;


public class OrderFactory {


    public static Order createOrder(String  orderID, String orderDetails, String orderType, int orderQuantity) {

        if (GenericHelper.isNullorEmpty(orderDetails) || GenericHelper.isNullorEmpty(orderType))
            return null;

        return new Order.Builder().setOrderID(orderID)
                .setOrderDetails(orderDetails)
                .setOrderType(orderType)
                .setOrderQuantity(orderQuantity)
                .build();
    }

}
