package Filter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServiceClass {
    private final static Connection conn ;

    static {
        String url = "jdbc:mysql://localhost:3306/j2ee";
        String username = "root";
        String password = "tiger";
        try {
            conn = DriverManager.getConnection(url , username , password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public Product filterProductByPrice(double productPrice) {
        String searchQuery = "SELECT * FROM PRODUCT_INFO WHERE PRODUCT_PRICE = ?";
        Product product = new Product() ;
        try {
            PreparedStatement pstmt = conn.prepareStatement(searchQuery);
            pstmt.setDouble(1 , productPrice);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                product =
                        new Product(rs.getInt(1) , rs.getString(2) ,
                                rs.getDouble(3) , rs.getString(4));
            }

        } catch (SQLException e) {

        }
        return  product ;

    }

    public Product filterProductByCategory(String productType) {
        String searchQuery = "SELECT * FROM PRODUCT_INFO WHERE PRODUCT_PRICE = ?";
        Product product = new Product() ;
        try {
            PreparedStatement pstmt = conn.prepareStatement(searchQuery);
            pstmt.setString(1 , productType);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                product =
                        new Product(rs.getInt(1) , rs.getString(2) ,
                                rs.getDouble(3) , rs.getString(4));
            }

        } catch (SQLException e) {

        }
        return  product ;
    }
}
