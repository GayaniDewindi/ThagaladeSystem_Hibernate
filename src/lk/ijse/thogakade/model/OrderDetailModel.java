package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 11/16/22 - 12:24 AM   
*/

import lk.ijse.thogakade.to.CartDetail;
import lk.ijse.thogakade.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailModel {
    public static boolean saveOrderDetails(ArrayList<CartDetail> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetail cartDetail : cartDetails) {
            if (!save(cartDetail)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(CartDetail cartDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO OrderDetail VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, cartDetail.getOrderId(), cartDetail.getCode(), cartDetail.getQty(), cartDetail.getUnitPrice());
    }
}
