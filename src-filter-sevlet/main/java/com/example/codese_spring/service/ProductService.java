package com.example.codese_spring.service;

import com.example.codese_spring.dto.*;
import com.example.codese_spring.repository.AuthRepository;
import com.example.codese_spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    AuthRepository authRepository;

    public List<ProductHomepageDTO> getAllProducts() {
        try {
            return productRepository.getAllProducts();
        } catch (Exception e) {
            System.out.println("Fail at repo");
        } finally {
            return productRepository.getAllProducts();
        }
    }

    public ProductDTO getProductById(String idInput) {
        try {
            if (productRepository.checkProductExistedById(idInput)) {
                return productRepository.getProductById(idInput);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean addProduct(ProductDTO productDTO) {
        try {
            if (!productRepository.checkProductExistedById(productDTO.getProductID()) && !productRepository.checkProductExistedByName(productDTO.getDisplay())) {
                if (productRepository.addProduct(productDTO) != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<ProductDTO> getProductByPriceWithOrder(Integer sortType) {
        try {
            switch (sortType) {
                case 0:
                    return productRepository.getAllPriceOutAsc(sortType);
                case 1:
                    return productRepository.getAllPriceOutDesc(sortType);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println("Loi roi");
            return null;
        }
    }

    public List<ProductDTO> getProductByDisplayWithOrder(Integer sortType) {
        try {
            switch (sortType) {
                case 0:
                    return productRepository.getAllDisplayAsc(sortType);
                case 1:
                    return productRepository.getAllDisplayDesc(sortType);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println("Loiiii");
            return null;
        }
    }

    public List<ProductDTO> getProductByDisplay(String display) {
        try {
            if (display == null) {
                return productRepository.getAllInfoProducts();
            } else {
                return productRepository.getProductByDisplay(display);
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Boolean updateProduct(ProductDTO productDTO) {
        try {
            if (productRepository.checkProductExistedById(productDTO.getProductID())) {
                if (productRepository.updateProduct1(productDTO) != 0 && productRepository.checkProductExistedByName(productDTO.getDisplay())) {
                    return true;
                } else {
                    System.out.println(productRepository.updateProduct(productDTO));
                    return false;
                }
            } else {
                System.out.println(productRepository.checkProductExistedById(productDTO.getProductID()));
                System.out.println(productRepository.checkProductExistedByName(productDTO.getDisplay()));
                System.out.println("vao day roi");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean deleteProduct(String productID) {
        try {
            if (productRepository.checkProductExistedById(productID) && productRepository.deleteProduct(productID) != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public ProductWithPagingDTO getAllProductWithPaging(Integer page, Integer size, String token) {
        Integer limit, offset;

        if (page != null && size != null) {
            limit = size;
            offset = (page - 1) * size;
        } else {
            offset = 0;
            size = 10;
            limit = 10;
        }
        List<ProductDTO> responseFullList = productRepository.getAllInfoProducts();
        // tra ve list
        List<ProductDTO> responseList = productRepository.getAllProductWithPaging(limit, offset);

        // dem tong so trang
        Integer totalPage;
        if (responseFullList.size() % size == 0) {
            totalPage = responseFullList.size() / size;
        } else {
            totalPage = responseFullList.size() / size + 1;
        }

        // page size
        Integer pageSize = size;

        // page length
        Integer pageLength = responseList.size();

        PaginationDTO paginationDTO = new PaginationDTO(totalPage, pageSize, pageLength);
        String responseAccountID = authRepository.getAccountID(token).getAccountID();
        ProductWithPagingDTO response = new ProductWithPagingDTO(responseList, paginationDTO, responseAccountID);
        return response;
    }
}
