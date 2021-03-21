package com.example.codese_spring.repository;

import com.example.codese_spring.dto.ProductDTO;
import com.example.codese_spring.dto.ProductHomepageDTO;
import com.example.codese_spring.exception.ProductNotEnoughException;
import com.example.codese_spring.helper.JdbcMapper.ProductDTOMapper;
import com.example.codese_spring.helper.JdbcMapper.ProductHomepageDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //get all homepage
    public List<ProductHomepageDTO> getAllProducts() {
        String sql = "select * from Product;";
        List<ProductHomepageDTO> product = jdbcTemplate.query(sql, new ProductHomepageDTOMapper());
        return product;
    }

    // get all
    public List<ProductDTO> getAllInfoProducts() {
        String sql = "select * from Product where deleted = 0;";
        List<ProductDTO> product = jdbcTemplate.query(sql, new ProductDTOMapper());
        return product;
    }

    // get all with pagination
    public List<ProductDTO> getAllProductWithPaging(Integer offset, Integer limit) {
        String sql = "select * from Product limit ?,?;";
        Object[] params = {limit, offset};
        return jdbcTemplate.query(sql, new ProductDTOMapper(), params);
    }
    // get by id
    public ProductDTO getProductById(String idInput) {
        String sql = "select * from Product where productID = ?;";
        Object[] params = {idInput};
        ProductDTO product = (ProductDTO) jdbcTemplate.queryForObject(sql, new ProductDTOMapper(), params);
        return product;
    }

    // check existed by id
    public Boolean checkProductExistedById(String idInput) {
        String sql = "select exists (select * from Product where productID = ? and deleted = 0);";
        Object[] params = {idInput};
        return jdbcTemplate.queryForObject(sql, Boolean.class, params);
    }

    // check existed by name
    public Boolean checkProductExistedByName(String display) {
        String sql = "select exists (select * from Product where display = ? and deleted = 0);";
        Object[] params = {display};
        return jdbcTemplate.queryForObject(sql, Boolean.class, params);
    }

    // check amount of product
    public Boolean checkAmountOfProduct(String productID, Integer amount) {
        String productName = this.getProductById(productID).getDisplay();
        Integer amountLeft = this.getProductById(productID).getAmount() - amount;
        if (amountLeft < 0) {
            throw new ProductNotEnoughException("Sản phẩm " + productName + " không còn!");
        } else {
            return true;
        }
    }

    // add
    public Integer addProduct(ProductDTO productDTO) {
        String sql = "insert into Product (productID, display, priceIn, priceOut, priceSale, amount, shipday, description, images) values (?,?,?,?,?,?,?,?,?)";
        String uuid = UUID.randomUUID().toString();
        Object[] params = {uuid, productDTO.getDisplay(), productDTO.getPriceIn(), productDTO.getPriceOut(), productDTO.getPriceSale(), productDTO.getAmount(), productDTO.getShipday(), productDTO.getDescription(), productDTO.getImages()};
        return jdbcTemplate.update(sql, params);
    }

    // get by price out asc
    public List<ProductDTO> getAllPriceOutAsc(Integer sortType) {
        String sql = "select * from Product order by priceOut ASC and deleted = 0;";
        List<ProductDTO> product = jdbcTemplate.query(sql, new ProductDTOMapper());
        return product;
    }

    // get by price out desc
    public List<ProductDTO> getAllPriceOutDesc(Integer sortType) {
        String sql = "select * from Product order by priceOut DESC and deleted = 0;";
        List<ProductDTO> product = jdbcTemplate.query(sql, new ProductDTOMapper());
        return product;
    }

    // get by display asc
    public List<ProductDTO> getAllDisplayAsc(Integer sortType) {
        String sql = "select * from Product order by display ASC and deleted = 0;";
        List<ProductDTO> product = jdbcTemplate.query(sql, new ProductDTOMapper());
        return product;
    }

    // get by display desc
    public List<ProductDTO> getAllDisplayDesc(Integer sortType) {
        String sql = "select * from Product order by display DESC and deleted = 0;";
        List<ProductDTO> product = jdbcTemplate.query(sql, new ProductDTOMapper());
        return product;
    }

    // get by display ignore lower/upper
    public List<ProductDTO> getProductByDisplay(String display) {
        String sql = "select * from Product where lower(display) = lower(?) and deleted = 0;";
        // String sql = "select * from Product where display ilike ?;";
        Object[] params = {display};
        return jdbcTemplate.query(sql, new ProductDTOMapper(), params);
    }

    public Integer updateProduct1(ProductDTO productDTO) {
        String sql = "update Product set display = ?, priceIn = ?, priceOut = ?, priceSale = ?, amount = ?, shipday = ?, description = ?, images = ? where productID = ?;";
        return jdbcTemplate.update(sql, productDTO.getDisplay(), productDTO.getPriceIn(), productDTO.getPriceOut(),
                productDTO.getPriceSale(), productDTO.getAmount(), productDTO.getShipday(), productDTO.getDescription(), productDTO.getImages(), productDTO.getProductID());
    }

    public Integer updateProduct(ProductDTO productDTO) {
        String sql = "update Product set display = ?, priceIn = ?, priceOut = ?, priceSale = ?, amount = ?, shipday = ?, description = ?, images = ? where productID = ?;";
        Object[] params = {productDTO.getDisplay(), productDTO.getPriceIn(), productDTO.getPriceOut(),
                productDTO.getPriceSale(), productDTO.getAmount(), productDTO.getShipday(), productDTO.getDescription(), productDTO.getImages(), productDTO.getProductID()};
        int[] types = {Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return jdbcTemplate.update(sql, params, types);
    }

    public Integer deleteProduct(String productID) {
        String sql = "update Product set deleted = 1 where productID = ?;";
        Object[] params = {productID};
        return jdbcTemplate.update(sql, params);
    }
}
